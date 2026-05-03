package com.smat.app.prevencao.repository;

import com.smat.app.prevencao.MateriaisPreventivos;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateriaisPreventivosRepository extends JpaRepositoryExtended<MateriaisPreventivos, Integer> {

    @Override
    default Updater<MateriaisPreventivos> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            entity.setDescricao(body.getDescricao());
            return entity;
        };
    }

    @Override
    default Class<MateriaisPreventivos> getClazz() {
        return MateriaisPreventivos.class;
    }
}

