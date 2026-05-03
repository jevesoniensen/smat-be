package com.smat.app.acidentes.repository;

import com.smat.app.acidentes.model.Medicos;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicosRepository extends JpaRepositoryExtended<Medicos, Integer> {
    @Override
    default Updater<Medicos> getUpdater() {
        return (body, entity) -> {
            entity.setUfCRM(body.getUfCRM());
            entity.setNome(body.getNome());
            entity.setCrm(body.getCrm());
            return entity;
        };
    }

    @Override
    default Class<Medicos> getClazz() {
        return Medicos.class;
    }
}
