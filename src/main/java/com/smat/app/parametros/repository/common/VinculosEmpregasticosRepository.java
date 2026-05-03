package com.smat.app.parametros.repository.common;

import com.smat.app.parametros.model.common.VinculosEmpregaticios;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VinculosEmpregasticosRepository extends JpaRepositoryExtended<VinculosEmpregaticios, Integer> {
    @Override
    default Updater<VinculosEmpregaticios> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<VinculosEmpregaticios> getClazz() {
        return VinculosEmpregaticios.class;
    }
}
