package com.smat.core.controleacesso.repository;

import com.smat.common.repository.JpaRepositoryExtended;
import com.smat.core.controleacesso.model.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuloRepository extends JpaRepositoryExtended<Modulo, Integer> {

    @Query(value = "SELECT * FROM smat.sp_smat_listar_menu(:userId)", nativeQuery = true)
    List<MenuResult> listarMenu(@Param("userId") Integer userId);

    interface MenuResult {
        Integer getModulo();
        String getNome();
        String getEstrutura();
        Integer getModuloPai();
        Integer getNivel();
        Integer getPaginaDefault();
        String getNomePaginaDefault();
        Integer getFilhos();
    }

    @Override
    default Updater<Modulo> getUpdater() {
        return (body, entity) -> {
            entity.setNome(body.getNome());
            return entity;
        };
    }

    @Override
    default Class<Modulo> getClazz() {
        return Modulo.class;
    }
}
