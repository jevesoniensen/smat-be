package com.smat.app.parametros.repository.hospitalar;

import com.smat.app.parametros.model.hospitalar.LocaisLesao;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocaisLesaoRepository extends JpaRepositoryExtended<LocaisLesao, Integer> {

    List<LocaisLesao> findAllByPaiId(Integer paiId);

    @Override
    default Updater<LocaisLesao> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            entity.setPaiId(body.getPaiId());
            return entity;
        };
    }

    @Override
    default Class<LocaisLesao> getClazz() {
        return LocaisLesao.class;
    }
}

