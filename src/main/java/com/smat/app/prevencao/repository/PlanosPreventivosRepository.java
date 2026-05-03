package com.smat.app.prevencao.repository;

import com.smat.app.prevencao.PlanosPreventivos;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanosPreventivosRepository extends JpaRepositoryExtended<PlanosPreventivos, Integer> {
    @Override
    default Updater<PlanosPreventivos> getUpdater() {
        return (body, entity)  -> {
            entity.setRegional(body.getRegional());
            entity.setResultadoPrevencao(body.getResultadoPrevencao());
            entity.setDataAbertura(body.getDataAbertura());
            entity.setDataFinalizacao(body.getDataFinalizacao());
            entity.setTitulo(body.getTitulo());
            return entity;
        };
    }

    @Override
    default Class<PlanosPreventivos> getClazz() {
        return PlanosPreventivos.class;
    }
}

