package com.smat.app.empresas.repository;

import com.smat.app.empresas.model.RamosAtividade;
import com.smat.app.empresas.model.RepresentantesEmpresa;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RamosAtividadeRepository extends JpaRepositoryExtended<RamosAtividade, Integer> {
    @Override
    default Updater<RamosAtividade> getUpdater() {
        return (body, entity) -> {
            entity.setId(body.getId());
            entity.setNome(body.getNome());
            entity.setCnae(body.getCnae());
            entity.setRamoSuperior(body.getRamoSuperior());
            return entity;
        };
    }

    @Override
    default Class<RamosAtividade> getClazz() {
        return RamosAtividade.class;
    }
}
