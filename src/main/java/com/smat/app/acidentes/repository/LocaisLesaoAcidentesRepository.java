package com.smat.app.acidentes.repository;

import com.smat.app.acidentes.model.LocaisLesaoAcidentes;
import com.smat.app.acidentes.model.LocaisLesaoAcidentesId;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaisLesaoAcidentesRepository extends JpaRepositoryExtended<LocaisLesaoAcidentes, LocaisLesaoAcidentesId> {
    @Override
    default Updater<LocaisLesaoAcidentes> getUpdater() {
        return (body, entity) -> {
            entity.setId(body.getId());
            return entity;
        };
    }

    @Override
    default Class<LocaisLesaoAcidentes> getClazz() {
        return LocaisLesaoAcidentes.class;
    }

    @Override
    default LocaisLesaoAcidentesId parseId(String id) {
        String[] parts = id.split("-");
        return new LocaisLesaoAcidentesId(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
    }
}
