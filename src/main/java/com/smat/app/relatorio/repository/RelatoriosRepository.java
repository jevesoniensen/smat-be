package com.smat.app.relatorio.repository;

import com.smat.app.relatorio.Relatorios;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatoriosRepository extends JpaRepositoryExtended<Relatorios, Integer> {

    @Override
    default Updater<Relatorios> getUpdater() {
        return (body, entity) -> {
            entity.setTipoAgrupamento(body.getTipoAgrupamento());
            entity.setLocal(body.getLocal());
            entity.setQueryLocal(body.getQueryLocal());
            entity.setPeriodicidade(body.getPeriodicidade());
            entity.setCampo1(body.getCampo1());
            entity.setQueryCampo1(body.getQueryCampo1());
            entity.setCampo2(body.getCampo2());
            entity.setQueryCampo2(body.getQueryCampo2());
            entity.setDataInicio(body.getDataInicio());
            entity.setDataFim(body.getDataFim());
            entity.setTitulo(body.getTitulo());
            entity.setTexto(body.getTexto());
            entity.setDataCriacao(body.getDataCriacao());
            return entity;
        };
    }

    @Override
    default Class<Relatorios> getClazz() {
        return Relatorios.class;
    }
}

