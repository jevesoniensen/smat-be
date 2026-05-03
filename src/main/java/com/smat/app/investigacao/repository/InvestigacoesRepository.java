package com.smat.app.investigacao.repository;

import com.smat.app.investigacao.model.Investigacoes;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestigacoesRepository extends JpaRepositoryExtended<Investigacoes, Integer> {
    @Override
    default Updater<Investigacoes> getUpdater() {
        return (body, entity) -> {
            entity.setAgenteSaude(body.getAgenteSaude());
            entity.setAcidente(body.getAcidente());
            entity.setDataAbertura(body.getDataAbertura());
            entity.setDataFinalizacao(body.getDataFinalizacao());
            entity.setTitulo(body.getTitulo());
            entity.setObsGerais(body.getObsGerais());
            return entity;
        };
    }

    @Override
    default Class<Investigacoes> getClazz() {
        return Investigacoes.class;
    }
}

