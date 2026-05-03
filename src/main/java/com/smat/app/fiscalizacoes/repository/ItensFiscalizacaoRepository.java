package com.smat.app.fiscalizacoes.repository;

import com.smat.app.fiscalizacoes.model.ItensFiscalizacao;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItensFiscalizacaoRepository extends JpaRepositoryExtended<ItensFiscalizacao, Integer> {
    @Override
    default Updater<ItensFiscalizacao> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<ItensFiscalizacao> getClazz() {
        return ItensFiscalizacao.class;
    }
}

