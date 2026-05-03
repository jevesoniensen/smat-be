package com.smat.app.parametros.repository.common;

import com.smat.app.parametros.model.common.Areas;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.stereotype.Repository;

@Repository
public interface AreasRepository extends JpaRepositoryExtended<Areas, Integer> {

    @Override
    default Updater<Areas> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<Areas> getClazz() {
        return Areas.class;
    }
}
