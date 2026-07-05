package com.smat.app.acidentes.service;

import com.smat.app.acidentes.dto.AcidenteDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AcidenteCreatedConsumerTest {

    @Mock
    private AcidenteService acidenteService;

    @InjectMocks
    private AcidenteCreatedConsumer acidenteCreatedConsumer;

    @Test
    void consume_shouldSaveAcidente() {
        // Arrange
        AcidenteDto acidenteDto = mock(AcidenteDto.class);

        // Act
        acidenteCreatedConsumer.consume(acidenteDto);

        // Assert
        verify(acidenteService).save(acidenteDto);
    }
}
