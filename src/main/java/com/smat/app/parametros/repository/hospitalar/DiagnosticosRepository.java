package com.smat.app.parametros.repository.hospitalar;

import com.smat.app.parametros.model.hospitalar.Diagnosticos;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticosRepository extends JpaRepositoryExtended<Diagnosticos, Integer> {

    @Override
    default Updater<Diagnosticos> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            entity.setCid10(body.getCid10());
            return entity;
        };
    }

    @Override
    default Class<Diagnosticos> getClazz() {
        return Diagnosticos.class;
    }
}

