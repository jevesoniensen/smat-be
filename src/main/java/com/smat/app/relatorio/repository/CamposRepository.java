package com.smat.app.relatorio.repository;

import com.smat.app.relatorio.Campos;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamposRepository extends JpaRepositoryExtended<Campos, Integer> {

    @Override
    default Updater<Campos> getUpdater() {
        return (body, entity) -> {
            entity.setTabela(body.getTabela());
            entity.setColuna(body.getColuna());
            entity.setPai(body.getPai());
            entity.setNome(body.getNome());
            entity.setLabel(body.getLabel());
            return entity;
        };
    }

    @Override
    default Class<Campos> getClazz() {
        return Campos.class;
    }
}

