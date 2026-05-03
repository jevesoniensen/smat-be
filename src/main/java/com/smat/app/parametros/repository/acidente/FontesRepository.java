package com.smat.app.parametros.repository.acidente;

import com.smat.app.parametros.model.acidente.Fontes;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FontesRepository extends JpaRepositoryExtended<Fontes, Integer> {
    @Override
    default Updater<Fontes> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<Fontes> getClazz() {
        return Fontes.class;
    }
}

