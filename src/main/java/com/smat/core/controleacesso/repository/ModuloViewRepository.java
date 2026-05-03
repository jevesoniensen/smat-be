package com.smat.core.controleacesso.repository;

import com.smat.common.repository.JpaRepositoryExtended;
import com.smat.core.controleacesso.model.ModuloView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloViewRepository extends JpaRepositoryExtended<ModuloView, Integer> {
    @Override
    default Updater<ModuloView> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<ModuloView> getClazz() {
        return ModuloView.class;
    }
}
