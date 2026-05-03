package com.smat.app.acidentes.repository;

import com.smat.app.acidentes.model.LocaisLesaoAcidentes;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaisLesaoAcidentesRepository extends JpaRepositoryExtended<LocaisLesaoAcidentes, Integer> {
    @Override
    default Updater<LocaisLesaoAcidentes> getUpdater() {
        return (body, entity) -> {
            entity.setLocalLesao(body.getLocalLesao());
            return entity;
        };
    }

    @Override
    default Class<LocaisLesaoAcidentes> getClazz() {
        return LocaisLesaoAcidentes.class;
    }
}
