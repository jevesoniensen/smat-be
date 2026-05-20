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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

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

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(AcidenteDto.class).flatMap(body -> {
            var entity = create(body);
            return ok()
                    .contentType(APPLICATION_JSON)
                    .body(fromValue(entity));
        });
    }

    @Transactional
    public AcidenteDto create(AcidenteDto acidenteDto) {

        var trabalhadorEntity = trabalhadorMapper.toEntity(acidenteDto.trabalhador());
        trabalhadorEntity = trabalhadoresRepository.save(trabalhadorEntity);
        var trabalhadorId = trabalhadorEntity.getTrabalhador();

        var acidenteEntity = acidenteMapper.toEntity(acidenteDto);
        acidenteEntity.setTrabalhador(trabalhadorId);
        acidenteEntity = acidentesRepository.save(acidenteEntity);

        var acidenteId = acidenteEntity.getAcidente();
        testemunhaMapper.toEntity(acidenteId, acidenteDto.testemunhas()).forEach(testemunhasRepository::save);

        acidenteDto.locaisLesaoAcidentes().stream().map(lla -> new LocaisLesaoAcidentes(acidenteId, lla))
                .forEach(locaisLesaoAcidentesRepository::save);

        return acidenteDto;
    }
}
