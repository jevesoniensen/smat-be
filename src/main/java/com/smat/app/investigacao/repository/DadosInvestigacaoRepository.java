package com.smat.app.investigacao.repository;

import com.smat.app.investigacao.model.DadosInvestigacao;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosInvestigacaoRepository extends JpaRepositoryExtended<DadosInvestigacao, Integer> {
    @Override
    default Updater<DadosInvestigacao> getUpdater() {
        return (body, entity) -> {
            entity.setDadoInvestigacao(body.getDadoInvestigacao());
            entity.setTipodepoimento(body.getTipodepoimento());
            entity.setRepresentanteEmpresa(body.getRepresentanteEmpresa());
            entity.setTestemunha(body.getTestemunha());
            entity.setAgenteSaude(body.getAgenteSaude());
            entity.setDataHora(body.getDataHora());
            entity.setAgenteCausador(body.getAgenteCausador());
            entity.setTrabalhador(body.getTrabalhador());
            entity.setDescricao(body.getDescricao());
            return entity;
        };
    }

    @Override
    default Class<DadosInvestigacao> getClazz() {
        return DadosInvestigacao.class;
    }
}

