package com.smat.app.acidentes.repository;

import com.smat.app.acidentes.model.TiposMedidasCorretivas;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposMedidasCorrativasRepository extends JpaRepositoryExtended<TiposMedidasCorretivas, Integer> {
    @Override
    default Updater<TiposMedidasCorretivas> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            entity.setDescricao(body.getDescricao());
            return entity;
        };
    }

    @Override
    default Class<TiposMedidasCorretivas> getClazz() {
        return TiposMedidasCorretivas.class;
    }
}
