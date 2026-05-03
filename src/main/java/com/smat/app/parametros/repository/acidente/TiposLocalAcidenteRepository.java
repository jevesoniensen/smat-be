package com.smat.app.parametros.repository.acidente;

import com.smat.app.parametros.model.acidente.TiposLocalAcidente;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposLocalAcidenteRepository extends JpaRepositoryExtended<TiposLocalAcidente, Integer> {
    @Override
    default Updater<TiposLocalAcidente> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<TiposLocalAcidente> getClazz() {
        return TiposLocalAcidente.class;
    }
}

