package com.smat.app.acidentes.service;

import com.smat.app.acidentes.dto.AcidenteDto;
import com.smat.app.acidentes.dto.TrabalhadorDto;
import com.smat.app.acidentes.mapper.AcidenteMapper;
import com.smat.app.acidentes.mapper.TestemunhaMapper;
import com.smat.app.acidentes.mapper.TrabalhadorMapper;
import com.smat.app.acidentes.model.Acidentes;
import com.smat.app.acidentes.model.Trabalhadores;
import com.smat.app.acidentes.repository.AcidentesRepository;
import com.smat.app.acidentes.repository.LocaisLesaoAcidentesRepository;
import com.smat.app.acidentes.repository.TestemunhasRepository;
import com.smat.app.acidentes.repository.TrabalhadoresRepository;
import com.smat.outbox.service.OutboxService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AcidenteServiceTest {

    @Mock
    private AcidentesRepository acidentesRepository;
    @Mock
    private TrabalhadoresRepository trabalhadoresRepository;
    @Mock
    private LocaisLesaoAcidentesRepository locaisLesaoAcidentesRepository;
    @Mock
    private TestemunhasRepository testemunhasRepository;
    @Mock
    private AcidenteMapper acidenteMapper;
    @Mock
    private TrabalhadorMapper trabalhadorMapper;
    @Mock
    private TestemunhaMapper testemunhaMapper;
    @Mock
    private OutboxService outboxService;

    @InjectMocks
    private AcidenteService acidenteService;

    @Test
    void save_shouldSaveAcidenteAndPublishToOutbox() {
        // Arrange
        TrabalhadorDto trabalhadorDto = new TrabalhadorDto(
                null, null, null, null, "Trabalhador", "123", "456", null, null, null, null, "M", null,
                null, null, null, null, null, null, null, null, null, null
        );
        AcidenteDto acidenteDto = new AcidenteDto(
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                trabalhadorDto, 1, 1, 1, 1, LocalDateTime.now(), "reg", "S", "N", 40,
                "desc", "num", LocalDateTime.now(), "nat", LocalDateTime.now(), "af", "int", "obs", 10,
                "S", new BigDecimal("1000.00"), "dist", LocalDateTime.now(), "sit", "diag",
                new ArrayList<>(), new HashSet<>()
        );

        Trabalhadores trabalhadorEntity = new Trabalhadores();
        trabalhadorEntity.setTrabalhador(100);
        
        Acidentes acidenteEntity = new Acidentes();
        acidenteEntity.setAcidente(200);

        when(trabalhadorMapper.toEntity(any())).thenReturn(trabalhadorEntity);
        when(trabalhadoresRepository.save(any())).thenReturn(trabalhadorEntity);
        when(acidenteMapper.toEntity(any())).thenReturn(acidenteEntity);
        when(acidentesRepository.save(any())).thenReturn(acidenteEntity);
        when(testemunhaMapper.toEntity(anyInt(), anyList())).thenReturn(List.of());

        // Act
        acidenteService.save(acidenteDto);

        // Assert
        verify(trabalhadoresRepository).save(trabalhadorEntity);
        verify(acidentesRepository).save(acidenteEntity);
        verify(outboxService).outbox(eq("AccidentIdsGenerated"), anyString(), any());
    }

    @Test
    void register_shouldPublishToOutbox() {
        // Arrange
        AcidenteDto acidenteDto = mock(AcidenteDto.class);

        // Act
        acidenteService.register(acidenteDto);

        // Assert
        verify(outboxService).outbox(eq("AccidentCreated"), anyString(), eq(acidenteDto));
    }
}
