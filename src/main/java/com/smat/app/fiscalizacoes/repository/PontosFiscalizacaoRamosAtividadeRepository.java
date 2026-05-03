package com.smat.app.fiscalizacoes.repository;

import com.smat.app.fiscalizacoes.model.PontosFiscalizacaoRamosAtividade;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontosFiscalizacaoRamosAtividadeRepository extends JpaRepositoryExtended<PontosFiscalizacaoRamosAtividade, Integer> {
    @Override
    default Updater<PontosFiscalizacaoRamosAtividade> getUpdater() {
        return (body, entity) -> {
            entity.setRamoAtividade(body.getRamoAtividade());
            return entity;
        };
    }

    @Override
    default Class<PontosFiscalizacaoRamosAtividade> getClazz() {
        return PontosFiscalizacaoRamosAtividade.class;
    }
}

