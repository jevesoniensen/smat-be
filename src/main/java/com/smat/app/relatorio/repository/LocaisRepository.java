package com.smat.app.relatorio.repository;

import com.smat.app.relatorio.Locais;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaisRepository extends JpaRepositoryExtended<Locais, Integer> {

    @Override
    default Updater<Locais> getUpdater() {
        return (body, entity) -> {
            entity.setTabela(body.getTabela());
            entity.setColuna(body.getColuna());
            entity.setLabel(body.getLabel());
            entity.setColunanome(body.getColunanome());
            return entity;
        };
    }

    @Override
    default Class<Locais> getClazz() {
        return Locais.class;
    }
}

