package com.smat.app.prevencao.repository;

import com.smat.app.prevencao.Treinamentos;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreinamentosRepository extends JpaRepositoryExtended<Treinamentos, Integer> {
    @Override
    default Updater<Treinamentos> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            entity.setDescricao(body.getDescricao());
            return entity;
        };
    }

    @Override
    default Class<Treinamentos> getClazz() {
        return Treinamentos.class;
    }
}

