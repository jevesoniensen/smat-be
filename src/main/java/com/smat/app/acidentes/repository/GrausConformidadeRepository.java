package com.smat.app.acidentes.repository;

import com.smat.app.acidentes.model.GrausConformidade;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrausConformidadeRepository extends JpaRepositoryExtended<GrausConformidade, Integer> {
    @Override
    default Updater<GrausConformidade> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            entity.setDescricao(body.getDescricao());
            return entity;
        };
    }

    @Override
    default Class<GrausConformidade> getClazz() {
        return GrausConformidade.class;
    }
}
