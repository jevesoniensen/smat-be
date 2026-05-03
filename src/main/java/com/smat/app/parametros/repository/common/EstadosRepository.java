package com.smat.app.parametros.repository.common;

import com.smat.app.parametros.model.common.Estados;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadosRepository extends JpaRepositoryExtended<Estados, Integer> {
    @Override
    default Updater<Estados> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            entity.setSigla(body.getSigla());
            return entity;
        };
    }

    @Override
    default Class<Estados> getClazz() {
        return Estados.class;
    }
}

