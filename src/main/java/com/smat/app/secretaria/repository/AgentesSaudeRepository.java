package com.smat.app.secretaria.repository;

import com.smat.app.secretaria.AgentesSaude;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentesSaudeRepository extends JpaRepositoryExtended<AgentesSaude, Integer> {

    @Override
    default Updater<AgentesSaude> getUpdater() {
        return (body, entity) -> {
            entity.setRegional(body.getRegional());
            entity.setNome(body.getNome());
            entity.setEmail(body.getEmail());
            return entity;
        };
    }

    @Override
    default Class<AgentesSaude> getClazz() {
        return AgentesSaude.class;
    }
}

