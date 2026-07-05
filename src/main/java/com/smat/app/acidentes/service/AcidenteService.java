package com.smat.app.acidentes.service;

import com.smat.app.acidentes.dto.AcidenteDto;
import com.smat.app.acidentes.mapper.AcidenteMapper;
import com.smat.app.acidentes.mapper.TestemunhaMapper;
import com.smat.app.acidentes.mapper.TrabalhadorMapper;
import com.smat.app.acidentes.model.LocaisLesaoAcidentes;
import com.smat.app.acidentes.repository.AcidentesRepository;
import com.smat.app.acidentes.repository.LocaisLesaoAcidentesRepository;
import com.smat.app.acidentes.repository.TestemunhasRepository;
import com.smat.app.acidentes.repository.TrabalhadoresRepository;
import com.smat.common.dto.ResponseStatus;
import com.smat.outbox.service.OutboxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.UUID;

import static com.smat.app.acidentes.dto.AcidenteIdsDto.acidentIdsDto;
import static com.smat.app.acidentes.dto.LocalLesaoAcidenteDto.localLesaoAcidente;
import static com.smat.common.dto.IdDto.id;
import static java.util.stream.Collectors.toMap;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@Service
@RequiredArgsConstructor
public class AcidenteService {

    private final AcidentesRepository acidentesRepository;
    private final TrabalhadoresRepository trabalhadoresRepository;
    private final LocaisLesaoAcidentesRepository locaisLesaoAcidentesRepository;
    private final TestemunhasRepository testemunhasRepository;
    private final AcidenteMapper acidenteMapper;
    private final TrabalhadorMapper trabalhadorMapper;
    private final TestemunhaMapper testemunhaMapper;
    private final OutboxService outboxService;

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(AcidenteDto.class).flatMap(body -> Mono.fromRunnable(() -> register(body))
                .subscribeOn(Schedulers.boundedElastic())
                .then(ok()
                        .contentType(APPLICATION_JSON)
                        .body(fromValue(new ResponseStatus("success", "Acidente criado com sucesso")))
                ));
    }

    public void register(AcidenteDto acidente){
        outboxService.outbox("AccidentCreated", UUID.randomUUID().toString(), acidente);
    }

    @Transactional
    public void save(AcidenteDto acidenteDto) {

        var trabalhador = acidenteDto.trabalhador();
        var trabalhadorEntity = trabalhadorMapper.toEntity(trabalhador);
        trabalhadorEntity = trabalhadoresRepository.save(trabalhadorEntity);
        var trabalhadorId = trabalhadorEntity.getTrabalhador();

        var acidenteEntity = acidenteMapper.toEntity(acidenteDto);
        acidenteEntity.setTrabalhador(trabalhadorId);
        acidenteEntity = acidentesRepository.save(acidenteEntity);

        var acidenteId = acidenteEntity.getAcidente();
        var testemunhasMap = testemunhaMapper.toEntity(acidenteId, acidenteDto.testemunhas()).stream()
                .map(testemunhasRepository::save)
                .map(t -> id(t.getId(), testemunhaMapper.toDto(t))).toList();

        var llas = acidenteDto.locaisLesaoAcidentes().stream().map(lla -> new LocaisLesaoAcidentes(acidenteId, lla))
                .map(locaisLesaoAcidentesRepository::save)
                .map(lla -> id(lla.getId().getLocalLesao(), localLesaoAcidente(lla.getId().getLocalLesao())))
                .toList();

        var acidentIdsDto = acidentIdsDto(
                id(acidenteId, acidenteDto),
                id(trabalhadorId, trabalhador), testemunhasMap, llas);

        outboxService.outbox("AccidentIdsGenerated", UUID.randomUUID().toString(), acidentIdsDto);
    }
}
