package com.smat.app.empresas.repository;

import com.smat.app.empresas.model.TelefonesEmpregadores;
import com.smat.app.empresas.model.TiposEmpregadores;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonesEmpregadoresRepository extends JpaRepositoryExtended<TelefonesEmpregadores, Integer> {
    @Override
    default Updater<TelefonesEmpregadores> getUpdater() {
        return (body, entity) -> {
            entity.setId(body.getId());
            entity.setEmpregador(body.getEmpregador());
            entity.setDescricao(body.getDescricao());
            entity.setNumero(body.getNumero());
            entity.setDdd(body.getDdd());
            return entity;
        };
    }

    @Override
    default Class<TelefonesEmpregadores> getClazz() {
        return TelefonesEmpregadores.class;
    }
}
