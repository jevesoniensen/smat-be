package com.smat.app.acidentes.repository;

import com.smat.app.acidentes.model.TiposDepoimento;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposDepoimentoRepository extends JpaRepositoryExtended<TiposDepoimento, Integer> {
    @Override
    default Updater<TiposDepoimento> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<TiposDepoimento> getClazz() {
        return TiposDepoimento.class;
    }
}
