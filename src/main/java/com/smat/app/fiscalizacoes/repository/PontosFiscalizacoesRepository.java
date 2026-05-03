package com.smat.app.fiscalizacoes.repository;

import com.smat.app.fiscalizacoes.model.PontosFiscalizacoes;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PontosFiscalizacoesRepository extends JpaRepositoryExtended<PontosFiscalizacoes, Integer> {
    @Override
    default Updater<PontosFiscalizacoes> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            entity.setDescricao(body.getDescricao());
            return entity;
        };
    }

    @Override
    default Class<PontosFiscalizacoes> getClazz() {
        return PontosFiscalizacoes.class;
    }
}

