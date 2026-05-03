package com.smat.app.fiscalizacoes.repository;

import com.smat.app.fiscalizacoes.model.MedidasCorretivasFiscalizacao;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedidasCorretivasFiscalizacaoRepository extends JpaRepositoryExtended<MedidasCorretivasFiscalizacao, Integer> {
    @Override
    default Updater<MedidasCorretivasFiscalizacao> getUpdater() {
        return (body, entity) -> {
            entity.setTramiteFiscalizacao(body.getTramiteFiscalizacao());
            entity.setTipoMedidaCorretiva(body.getTipoMedidaCorretiva());
            entity.setPrazoDias(body.getPrazoDias());
            entity.setObservacao(body.getObservacao());
            return entity;
        };
    }

    @Override
    default Class<MedidasCorretivasFiscalizacao> getClazz() {
        return MedidasCorretivasFiscalizacao.class;
    }
}

