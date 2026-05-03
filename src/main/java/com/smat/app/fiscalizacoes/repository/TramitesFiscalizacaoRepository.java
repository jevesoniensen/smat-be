package com.smat.app.fiscalizacoes.repository;

import com.smat.app.fiscalizacoes.model.TramitesFiscalizacao;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TramitesFiscalizacaoRepository extends JpaRepositoryExtended<TramitesFiscalizacao, Integer> {
    @Override
    default Updater<TramitesFiscalizacao> getUpdater() {
        return (body, entity) -> {
            entity.setFiscalizacao(body.getFiscalizacao());
            entity.setStatus(body.getStatus());
            entity.setData(body.getData());
            return entity;
        };
    }

    @Override
    default Class<TramitesFiscalizacao> getClazz() {
        return TramitesFiscalizacao.class;
    }
}

