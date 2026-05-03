package com.smat.app.prevencao.repository;

import com.smat.app.prevencao.TreinamentosPlanosPreventivos;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinamentosPlanosPreventivosRepository extends JpaRepositoryExtended<TreinamentosPlanosPreventivos, Integer> {

    @Override
    default Updater<TreinamentosPlanosPreventivos> getUpdater() {
        return (body, entity) -> {
            entity.setPlanoPreventivo(body.getPlanoPreventivo());
            return entity;
        };
    }

    @Override
    default Class<TreinamentosPlanosPreventivos> getClazz() {
        return TreinamentosPlanosPreventivos.class;
    }
}

