package com.smat.app.acidentes.mapper;

import com.smat.app.acidentes.dto.TestemunhaDto;
import com.smat.app.acidentes.model.Testemunhas;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

@Component
public class TestemunhaMapper {

    public List<Testemunhas> toEntity(@NotNull Integer acidenteId, List<TestemunhaDto> dtos) {

        return emptyIfNull(dtos).stream()
                .filter(Objects::nonNull)
                .map(dto -> toEntity(acidenteId, dto))
                .toList();
    }

    public Testemunhas toEntity(@NotNull Integer acidenteId, @NotNull TestemunhaDto dto) {
        Testemunhas entity = new Testemunhas();
        entity.setAcidente(acidenteId);
        entity.setMunicipio(dto.municipio());
        entity.setNome(dto.nome());
        entity.setNumero(dto.numero());
        entity.setRua(dto.rua());
        entity.setBairro(dto.bairro());
        entity.setCep(dto.cep());
        entity.setComplemento(dto.complemento());
        entity.setTelefone(dto.telefone());
        entity.setDdd(dto.ddd());
        return entity;
    }

    public TestemunhaDto toDto(Testemunhas entity) {
        if (entity == null) {
            return null;
        }
        return new TestemunhaDto(
                entity.getMunicipio(),
                entity.getNome(),
                entity.getNumero(),
                entity.getRua(),
                entity.getBairro(),
                entity.getCep(),
                entity.getComplemento(),
                entity.getTelefone(),
                entity.getDdd()
        );
    }
}
