package com.smat.app.parametros.repository.common;

import com.smat.app.parametros.model.common.EstadosCivis;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadosCivisRepository extends JpaRepositoryExtended<EstadosCivis, Integer> {
    @Override
    default Updater<EstadosCivis> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<EstadosCivis> getClazz() {
        return EstadosCivis.class;
    }
}

