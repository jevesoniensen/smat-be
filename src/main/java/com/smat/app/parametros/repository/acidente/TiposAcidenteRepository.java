package com.smat.app.parametros.repository.acidente;

import com.smat.app.parametros.model.acidente.TiposAcidente;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposAcidenteRepository extends JpaRepositoryExtended<TiposAcidente, Integer> {
    @Override
    default Updater<TiposAcidente> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<TiposAcidente> getClazz() {
        return TiposAcidente.class;
    }
}

