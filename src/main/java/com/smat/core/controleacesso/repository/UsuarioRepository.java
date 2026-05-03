package com.smat.core.controleacesso.repository;

import com.smat.common.repository.JpaRepositoryExtended;
import com.smat.core.controleacesso.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepositoryExtended<Usuario, Integer> {

    List<Usuario> findByNome(String nome);

    @Override
    default Updater<Usuario> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            entity.setSenha(body.getSenha());
            entity.setAgentesaude(body.getAgentesaude());
            return entity;
        };
    }

    @Override
    default Class<Usuario> getClazz() {
        return Usuario.class;
    }
}
