package com.smat.app.investigacao.repository;

import com.smat.app.investigacao.model.MedidasCorretivasInvestigacao;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedidasCorretivasInvestigacaoRepository extends JpaRepositoryExtended<MedidasCorretivasInvestigacao, Integer> {
    @Override
    default Updater<MedidasCorretivasInvestigacao> getUpdater() {
        return (body, entity) -> {
            entity.setTipoMedidaCorretiva(body.getTipoMedidaCorretiva());
            entity.setPrazoDias(body.getPrazoDias());
            entity.setObservacao(body.getObservacao());
            return entity;
        };
    }

    @Override
    default Class<MedidasCorretivasInvestigacao> getClazz() {
        return MedidasCorretivasInvestigacao.class;
    }
}

