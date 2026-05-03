package com.smat.app.parametros.repository.acidente;

import com.smat.app.parametros.model.acidente.LocaisAtendimento;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaisAtendimentoRepository extends JpaRepositoryExtended<LocaisAtendimento, Integer> {
    @Override
    default Updater<LocaisAtendimento> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            entity.setMunicipio(body.getMunicipio());
            return entity;
        };
    }

    @Override
    default Class<LocaisAtendimento> getClazz() {
        return LocaisAtendimento.class;
    }
}

