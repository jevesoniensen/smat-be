package com.smat.app.fiscalizacoes.repository;

import com.smat.app.fiscalizacoes.model.PontosFiscalizacaoItensFiscal;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontosFiscalizacaoItensFiscalRepository extends JpaRepositoryExtended<PontosFiscalizacaoItensFiscal, Integer> {
    @Override
    default Updater<PontosFiscalizacaoItensFiscal> getUpdater() {
        return (body, entity) -> {
            entity.setItemFiscalizacao(body.getItemFiscalizacao());
            return entity;
        };
    }

    @Override
    default Class<PontosFiscalizacaoItensFiscal> getClazz() {
        return PontosFiscalizacaoItensFiscal.class;
    }
}

