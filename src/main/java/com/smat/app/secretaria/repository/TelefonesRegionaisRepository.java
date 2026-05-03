package com.smat.app.secretaria.repository;

import com.smat.app.secretaria.TelefonesRegionais;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonesRegionaisRepository extends JpaRepositoryExtended<TelefonesRegionais, Integer> {

    @Override
    default Updater<TelefonesRegionais> getUpdater() {
        return (body, entity) -> {
            entity.setRegional(body.getRegional());
            entity.setDescricao(body.getDescricao());
            entity.setNumero(body.getNumero());
            entity.setDdd(body.getDdd());
            return entity;
        };
    }

    @Override
    default Class<TelefonesRegionais> getClazz() {
        return TelefonesRegionais.class;
    }
}

