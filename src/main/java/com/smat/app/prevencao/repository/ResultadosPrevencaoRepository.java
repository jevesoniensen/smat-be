package com.smat.app.prevencao.repository;

import com.smat.app.prevencao.ResultadosPrevencao;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultadosPrevencaoRepository extends JpaRepositoryExtended<ResultadosPrevencao, Integer> {

    List<ResultadosPrevencao> findByDescricao(String descricao);

    @Override
    default Updater<ResultadosPrevencao> getUpdater() {
        return (body, entity) -> {
            entity.setDescricao(body.getDescricao());
            return entity;
        };
    }

    @Override
    default Class<ResultadosPrevencao> getClazz() {
        return ResultadosPrevencao.class;
    }
}

