package com.smat.app.parametros.repository.common;

import com.smat.app.parametros.model.common.Ocupacoes;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcupacoesRepository extends JpaRepositoryExtended<Ocupacoes, Integer> {

    @Override
    default Updater<Ocupacoes> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            entity.setCbo(body.getCbo());
            return entity;
        };
    }

    @Override
    default Class<Ocupacoes> getClazz() {
        return Ocupacoes.class;
    }
}

