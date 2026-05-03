package com.smat.app.acidentes.repository;

import com.smat.app.acidentes.model.TiposAgrupamento;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposAgrupamentoRepository extends JpaRepositoryExtended<TiposAgrupamento, Integer> {
    @Override
    default Updater<TiposAgrupamento> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<TiposAgrupamento> getClazz() {
        return TiposAgrupamento.class;
    }
}
