package com.smat.app.parametros.repository.common;

import com.smat.app.parametros.model.common.Municipios;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface MunicipiosRepository extends JpaRepositoryExtended<Municipios, Integer> {

    List<Municipios> findBySigla(String sigla);

    @Override
    default Updater<Municipios> getUpdater() {
        return (body, entity) -> {
            entity.setRegional(body.getRegional());
            entity.setNome(body.getNome());
            entity.setSigla(body.getSigla());
            entity.setPopulacao(body.getPopulacao());
            return entity;
        };
    }

    @Override
    default Class<Municipios> getClazz() {
        return Municipios.class;
    }
}

