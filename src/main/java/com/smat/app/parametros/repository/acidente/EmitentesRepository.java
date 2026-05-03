package com.smat.app.parametros.repository.acidente;

import com.smat.app.parametros.model.acidente.Emitentes;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmitentesRepository extends JpaRepositoryExtended<Emitentes, Integer> {

    @Override
    default Updater<Emitentes> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<Emitentes> getClazz() {
        return Emitentes.class;
    }
}

