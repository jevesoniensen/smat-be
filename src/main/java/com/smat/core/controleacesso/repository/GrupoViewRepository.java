package com.smat.core.controleacesso.repository;

import com.smat.common.repository.JpaRepositoryExtended;
import com.smat.core.controleacesso.model.Grupo;
import com.smat.core.controleacesso.model.GrupoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GrupoViewRepository extends JpaRepositoryExtended<GrupoView, Integer> {

   // @EntityGraph(attributePaths = {"modulos"})
    Optional<GrupoView> findById(Integer id);

    List<Grupo> findByNome(String nome);

    @Override
    default Updater<GrupoView> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<GrupoView> getClazz() {
        return GrupoView.class;
    }
}
