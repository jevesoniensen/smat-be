package com.smat.app.acidentes.dto;

import com.smat.common.dto.IdDto;

import java.util.List;

public record AcidentIdsDto(IdDto<AcidenteDto> acidente,
                            IdDto<TrabalhadorDto> trabalhador,
                            List<IdDto<TestemunhaDto>> testemunha,
                            List<IdDto<LocalLesaoAcidenteDto>> llas) {
    public static AcidentIdsDto acidentIdsDto(IdDto<AcidenteDto> acidente,
                                    IdDto<TrabalhadorDto> trabalhador,
                                    List<IdDto<TestemunhaDto>> testemunha,
                                    List<IdDto<LocalLesaoAcidenteDto>> llas) {
        return new AcidentIdsDto(acidente, trabalhador, testemunha, llas);
    }
}
