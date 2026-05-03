package com.smat.app.parametros.repository.acidente;

import com.smat.app.parametros.model.acidente.AgentesCausadores;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentesCausadoresRepository extends JpaRepositoryExtended<AgentesCausadores, Integer> {

    List<AgentesCausadores> findAllByPaiId(Integer paiId);

    @Override
    default Updater<AgentesCausadores> getUpdater() {
        return (body, entity) -> {
            entity.setPaiId(body.getPaiId());
            entity.setNome(body.getNome());
            entity.setDescricao(body.getDescricao());
            return entity;
        };
    }

    @Override
    default Class<AgentesCausadores> getClazz() {
        return AgentesCausadores.class;
    }
}

