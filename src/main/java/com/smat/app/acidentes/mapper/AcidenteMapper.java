package com.smat.app.acidentes.mapper;

import com.smat.app.acidentes.dto.AcidenteDto;
import com.smat.app.acidentes.dto.TestemunhaDto;
import com.smat.app.acidentes.dto.TrabalhadorDto;
import com.smat.app.acidentes.model.Acidentes;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class AcidenteMapper {

    public Acidentes toEntity(AcidenteDto dto) {
        if (dto == null) {
            return null;
        }

        Acidentes entity = new Acidentes();
        entity.setArea(dto.area());
        entity.setVinculoEmpregaticio(dto.vinculoEmpregaticio());
        entity.setOcupacao(dto.ocupacao());
        entity.setLocalAtendimento(dto.localAtendimento());
        entity.setEmpregador(dto.empregador());
        entity.setMedico(dto.medico());
        entity.setDiagnostico(dto.diagnostico());
        entity.setFonte(dto.fonte());
        entity.setAgenteCausador(dto.agenteCausador());
        entity.setTipoLocalAcidente(dto.tipoLocalAcidente());
        entity.setEmpregadorTerceiro(dto.empregadorTerceiro());
        entity.setTipoAcidente(dto.tipoAcidente());
        entity.setEmitente(dto.emitente());
        entity.setMunicipio(dto.municipio());
        entity.setDataAcidente(dto.dataAcidente());
        entity.setRegistroPolicial(dto.registroPolicial());
        entity.setAmputacao(dto.amputacao());
        entity.setObito(dto.obito());
        entity.setHorasTrabalhadas(dto.horasTrabalhadas());
        entity.setDescLocalAcidente(dto.descLocalAcidente());
        entity.setNumDocFonte(dto.numDocFonte());
        entity.setDataEmissaoFonte(dto.dataEmissaoFonte());
        entity.setNaturezaLesao(dto.naturezaLesao());
        entity.setDataHoraDiagnostico(dto.dataHoraDiagnostico());
        entity.setAfastamento(dto.afastamento());
        entity.setInternacao(dto.internacao());
        entity.setObservacaoDiagnostico(dto.observacaoDiagnostico());
        entity.setDuracaoTratamento(dto.duracaoTratamento());
        entity.setAposentado(dto.aposentado());
        entity.setRemuneracao(dto.remuneracao());
        entity.setDistritoSaude(dto.distritoSaude());
        entity.setUltimaTrabalhado(dto.ultimaTrabalhado());
        entity.setDescricaoSituacaoGeradora(dto.descricaoSituacaoGeradora());
        entity.setDescricaoDiagnostico(dto.descricaoDiagnostico());

        return entity;
    }

    public AcidenteDto toDto(@NotNull Acidentes acidente,
                             @NotNull TrabalhadorDto trabalhadorDto,
                             @NotNull List<TestemunhaDto> testemunhasDto,
                             @NotNull Set<Integer> locaisLesaoAcidentes) {
        return new AcidenteDto(
                acidente.getArea(),
                acidente.getVinculoEmpregaticio(),
                acidente.getOcupacao(),
                acidente.getLocalAtendimento(),
                acidente.getEmpregador(),
                acidente.getMedico(),
                acidente.getDiagnostico(),
                acidente.getFonte(),
                acidente.getAgenteCausador(),
                acidente.getTipoLocalAcidente(),
                trabalhadorDto,
                acidente.getEmpregadorTerceiro(),
                acidente.getTipoAcidente(),
                acidente.getEmitente(),
                acidente.getMunicipio(),
                acidente.getDataAcidente(),
                acidente.getRegistroPolicial(),
                acidente.getAmputacao(),
                acidente.getObito(),
                acidente.getHorasTrabalhadas(),
                acidente.getDescLocalAcidente(),
                acidente.getNumDocFonte(),
                acidente.getDataEmissaoFonte(),
                acidente.getNaturezaLesao(),
                acidente.getDataHoraDiagnostico(),
                acidente.getAfastamento(),
                acidente.getInternacao(),
                acidente.getObservacaoDiagnostico(),
                acidente.getDuracaoTratamento(),
                acidente.getAposentado(),
                acidente.getRemuneracao(),
                acidente.getDistritoSaude(),
                acidente.getUltimaTrabalhado(),
                acidente.getDescricaoSituacaoGeradora(),
                acidente.getDescricaoDiagnostico(),
                testemunhasDto,
                locaisLesaoAcidentes
        );
    }
}
