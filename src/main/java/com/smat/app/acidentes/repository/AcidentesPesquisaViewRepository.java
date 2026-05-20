package com.smat.app.acidentes.repository;

import com.smat.app.acidentes.model.AcidentesPesquisaView;
import com.smat.common.repository.JpaRepositoryExtended;
import com.smat.core.controleacesso.model.Grupo;
import com.smat.core.controleacesso.model.GrupoView;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AcidentesPesquisaViewRepository extends JpaRepositoryExtended<AcidentesPesquisaView, Integer> {

    Optional<AcidentesPesquisaView> findById(Integer id);

    @Override
    default Updater<AcidentesPesquisaView> getUpdater() {
        throw new RuntimeException("Não é permitido atualizar um AcidentesPesquisaView");
    }

    @Override
    default Class<AcidentesPesquisaView> getClazz() {
        return AcidentesPesquisaView.class;
    }
}
