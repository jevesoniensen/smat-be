package com.smat.app.acidentes.service;

import com.smat.app.acidentes.dto.AcidenteDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AcidenteCreatedConsumer {

    private final AcidenteService acidenteService;

    @KafkaListener(topics = "AccidentCreated")
    public void consume(AcidenteDto acidenteDto) {
        log.debug("Consumed message from AccidentCreated: {}", acidenteDto);
        acidenteService.save(acidenteDto);
    }
}
