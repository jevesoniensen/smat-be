package com.smat.app.acidentes.dto;

import com.smat.common.dto.IdDto;

import java.util.List;

public record AcidenteIdsDto(IdDto<AcidenteDto> acidente,
                             IdDto<TrabalhadorDto> trabalhador,
                             List<IdDto<TestemunhaDto>> testemunha,
                             List<IdDto<LocalLesaoAcidenteDto>> llas) {
    public static AcidenteIdsDto acidentIdsDto(IdDto<AcidenteDto> acidente,
                                               IdDto<TrabalhadorDto> trabalhador,
                                               List<IdDto<TestemunhaDto>> testemunha,
                                               List<IdDto<LocalLesaoAcidenteDto>> llas) {
        return new AcidenteIdsDto(acidente, trabalhador, testemunha, llas);
    }
}
