package com.smat.app.monitores.repository;

import com.smat.app.monitores.model.Periodicidades;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodicidadesRepository extends JpaRepositoryExtended<Periodicidades, Integer> {
    @Override
    default Updater<Periodicidades> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<Periodicidades> getClazz() {
        return Periodicidades.class;
    }
}

