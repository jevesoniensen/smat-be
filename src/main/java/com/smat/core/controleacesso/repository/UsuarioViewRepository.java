package com.smat.core.controleacesso.repository;

import com.smat.common.repository.JpaRepositoryExtended;
import com.smat.core.controleacesso.model.Usuario;
import com.smat.core.controleacesso.model.UsuarioView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioViewRepository extends JpaRepositoryExtended<UsuarioView, Integer> {
    @Override
    default Updater<UsuarioView> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            entity.setSenha(body.getSenha());
            entity.setAgentesaude(body.getAgentesaude());
            return entity;
        };
    }

    @Override
    default Class<UsuarioView> getClazz() {
        return UsuarioView.class;
    }
}
