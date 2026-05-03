package com.smat.app.empresas.repository;

import com.smat.app.fiscalizacoes.model.Empregadores;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpregadoresRepository extends JpaRepositoryExtended<Empregadores, Integer> {

    List<Empregadores> findByRazaoSocialContainingIgnoreCase(String razaoSocial);

    @Override
    default Updater<Empregadores> getUpdater() {
        return (body, entity) -> {
            entity.setRamoAtividade(body.getRamoAtividade());
            entity.setMunicipio(body.getMunicipio());
            entity.setTipoEmpregador(body.getTipoEmpregador());
            entity.setRazaoSocial(body.getRazaoSocial());
            entity.setDocumento(body.getDocumento());
            entity.setNumero(body.getNumero());
            entity.setRua(body.getRua());
            entity.setBairro(body.getBairro());
            entity.setCep(body.getCep());
            entity.setComplemento(body.getComplemento());
            return entity;
        };
    }

    @Override
    default Class<Empregadores> getClazz() {
        return Empregadores.class;
    }
}
