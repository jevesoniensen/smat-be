package com.smat.app.empresas.repository;

import com.smat.app.empresas.model.TiposEmpregadores;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposEmpregadoresRepository extends JpaRepositoryExtended<TiposEmpregadores, Integer> {
    @Override
    default Updater<TiposEmpregadores> getUpdater() {
        return (body, entity) -> {
            entity.setId(body.getId());
            entity.setNome(body.getNome());
            entity.setDocIdentificador(body.getDocIdentificador());
            return entity;
        };
    }

    @Override
    default Class<TiposEmpregadores> getClazz() {
        return TiposEmpregadores.class;
    }
}

