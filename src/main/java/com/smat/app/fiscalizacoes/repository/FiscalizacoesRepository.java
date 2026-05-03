package com.smat.app.fiscalizacoes.repository;

import com.smat.app.fiscalizacoes.model.Fiscalizacoes;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiscalizacoesRepository extends JpaRepositoryExtended<Fiscalizacoes, Integer> {
    @Override
    default Updater<Fiscalizacoes> getUpdater() {
        return (body, entity) -> {
            entity.setAgenteSaude(body.getAgenteSaude());
            entity.setEmpregador(body.getEmpregador());
            entity.setDataAbertura(body.getDataAbertura());
            entity.setDataFinalizacao(body.getDataFinalizacao());
            entity.setTitulo(body.getTitulo());
            entity.setObsGerais(body.getObsGerais());
            return entity;
        };
    }

    @Override
    default Class<Fiscalizacoes> getClazz() {
        return Fiscalizacoes.class;
    }
}

