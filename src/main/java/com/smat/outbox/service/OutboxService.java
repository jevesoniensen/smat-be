package com.smat.outbox.service;

import tools.jackson.databind.ObjectMapper;
import com.smat.outbox.model.Outbox;
import com.smat.outbox.repository.OutboxRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OutboxService {

    private final OutboxRepository outboxRepository;
    private final ObjectMapper objectMapper;

    public <T> void outbox(String aggregateType, String aggregateId, T payload) {

        Outbox outbox = Outbox.builder()
                .id(UUID.randomUUID())
                .aggregateType(aggregateType)
                .aggregateId(aggregateId)
                .type(payload.getClass().getName())
                .payload(payload)
                .build();

        outboxRepository.save(outbox);
    }
}
