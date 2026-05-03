package com.smat.app.prevencao.repository;

import com.smat.app.prevencao.MateriaisSolicitados;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaisSolicitadosRepository extends JpaRepositoryExtended<MateriaisSolicitados, Integer> {

    @Override
    default Updater<MateriaisSolicitados> getUpdater() {
        return (body, entity) -> {
            entity.setMaterialPreventivo(body.getMaterialPreventivo());
            entity.setQuantidadeObservacao(body.getQuantidadeObservacao());
            return entity;
        };
    }

    @Override
    default Class<MateriaisSolicitados> getClazz() {
        return MateriaisSolicitados.class;
    }
}

