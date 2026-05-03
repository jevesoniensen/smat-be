package com.smat.app.monitores.repository;

import com.smat.app.monitores.model.Monitores;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoresRepository extends JpaRepositoryExtended<Monitores, Integer> {
    @Override
    default Updater<Monitores> getUpdater() {
        return (body, entity) -> {
            entity.setPeriodicidade(body.getPeriodicidade());
            entity.setCampo(body.getCampo());
            entity.setMaxAcidente(body.getMaxAcidente());
            entity.setUltimaDataExecucao(body.getUltimaDataExecucao());
            entity.setQueryCampo(body.getQueryCampo());
            return entity;
        };
    }

    @Override
    default Class<Monitores> getClazz() {
        return Monitores.class;
    }
}

