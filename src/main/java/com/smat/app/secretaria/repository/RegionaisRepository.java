package com.smat.app.secretaria.repository;

import com.smat.app.secretaria.Regionais;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionaisRepository extends JpaRepositoryExtended<Regionais, Integer> {

    @Override
    default Updater<Regionais> getUpdater(){
        return (body, entity) -> {
            entity.setMunicipio(body.getMunicipio());
            entity.setEstado(body.getEstado());
            entity.setNome(body.getNome());
            entity.setNumero(body.getNumero());
            entity.setRua(body.getRua());
            entity.setBairro(body.getBairro());
            entity.setCep(body.getCep());
            entity.setComplemento(body.getComplemento());
            return entity;
        };
    }

    @Override
    default Class<Regionais> getClazz() {
        return Regionais.class;
    }
}

