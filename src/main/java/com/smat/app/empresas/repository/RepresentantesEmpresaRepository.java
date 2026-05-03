package com.smat.app.empresas.repository;

import com.smat.app.empresas.model.RepresentantesEmpresa;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentantesEmpresaRepository extends JpaRepositoryExtended<RepresentantesEmpresa, Integer> {
    @Override
    default Updater<RepresentantesEmpresa> getUpdater() {
        return (body, entity) -> {
            entity.setId(body.getId());
            entity.setNome(body.getNome());
            entity.setEmpregador(body.getEmpregador());
            return entity;
        };
    }

    @Override
    default Class<RepresentantesEmpresa> getClazz() {
        return RepresentantesEmpresa.class;
    }
}
