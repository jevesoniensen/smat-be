package com.smat.core.controleacesso.repository;

import com.smat.common.repository.JpaRepositoryExtended;
import com.smat.core.controleacesso.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GrupoRepository extends JpaRepositoryExtended<Grupo, Integer> {

    Optional<Grupo> findById(Integer id);

    List<Grupo> findByNome(String nome);

    @Override
    default Updater<Grupo> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<Grupo> getClazz() {
        return Grupo.class;
    }
}
