package com.smat.app.fiscalizacoes.repository;

import com.smat.app.fiscalizacoes.model.Roteiros;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoteirosRepository extends JpaRepositoryExtended<Roteiros, Integer> {
    @Override
    default Updater<Roteiros> getUpdater() {
        return (body, entity) -> {
            entity.setFiscalizacao(body.getFiscalizacao());
            entity.setItemFiscalizacao(body.getItemFiscalizacao());
            entity.setGrauConformidade(body.getGrauConformidade());
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<Roteiros> getClazz() {
        return Roteiros.class;
    }
}

