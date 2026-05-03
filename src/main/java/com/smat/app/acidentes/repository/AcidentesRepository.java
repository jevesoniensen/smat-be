package com.smat.app.acidentes.repository;

import com.smat.app.acidentes.model.Acidentes;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcidentesRepository extends JpaRepositoryExtended<Acidentes, Integer> {
    @Override
    default Updater<Acidentes> getUpdater() {
        return (body, entity) -> {
            entity.setArea(body.getArea());
            entity.setVinculoEmpregaticio(body.getVinculoEmpregaticio());
            entity.setOcupacao(body.getOcupacao());
            entity.setLocalAtendimento(body.getLocalAtendimento());
            entity.setEmpregador(body.getEmpregador());
            entity.setMedico(body.getMedico());
            entity.setDiagnostico(body.getDiagnostico());
            entity.setFonte(body.getFonte());
            entity.setAgenteCausador(body.getAgenteCausador());
            entity.setTipoLocalAcidente(body.getTipoLocalAcidente());
            entity.setTrabalhador(body.getTrabalhador());
            entity.setEmpregadorTerceiro(body.getEmpregadorTerceiro());
            entity.setTipoAcidente(body.getTipoAcidente());
            entity.setEmitente(body.getEmitente());
            entity.setMunicipio(body.getMunicipio());
            entity.setDataAcidente(body.getDataAcidente());
            entity.setRegistroPolicial(body.getRegistroPolicial());
            entity.setAmputacao(body.getAmputacao());
            entity.setObito(body.getObito());
            entity.setHorasTrabalhadas(body.getHorasTrabalhadas());
            entity.setDescLocalAcidente(body.getDescLocalAcidente());
            entity.setNumDocFonte(body.getNumDocFonte());
            entity.setDataEmissaoFonte(body.getDataEmissaoFonte());
            entity.setNaturezaLesao(body.getNaturezaLesao());
            entity.setDataHoraDiagnostico(body.getDataHoraDiagnostico());
            entity.setAfastamento(body.getAfastamento());
            entity.setInternacao(body.getInternacao());
            entity.setObservacaoDiagnostico(body.getObservacaoDiagnostico());
            entity.setDuracaoTratamento(body.getDuracaoTratamento());
            entity.setAposentado(body.getAposentado());
            entity.setRemuneracao(body.getRemuneracao());
            entity.setDistritoSaude(body.getDistritoSaude());
            entity.setUltimaTrabalhado(body.getUltimaTrabalhado());
            entity.setDescricaoSituacaoGeradora(body.getDescricaoSituacaoGeradora());
            entity.setDescricaoDiagnostico(body.getDescricaoDiagnostico());
            return entity;
        };
    }

    @Override
    default Class<Acidentes> getClazz() {
        return Acidentes.class;
    }
}
