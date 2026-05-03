package com.smat.app.acidentes.repository;

import com.smat.app.acidentes.model.Testemunhas;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestemunhasRepository extends JpaRepositoryExtended<Testemunhas, Integer> {
    @Override
    default Updater<Testemunhas> getUpdater() {
        return (body, entity) -> {
            entity.setAcidente(body.getAcidente());
            entity.setMunicipio(body.getMunicipio());
            entity.setNome(body.getNome());
            entity.setNumero(body.getNumero());
            entity.setRua(body.getRua());
            entity.setBairro(body.getBairro());
            entity.setCep(body.getCep());
            entity.setComplemento(body.getComplemento());
            entity.setTelefone(body.getTelefone());
            entity.setDdd(body.getDdd());
            return entity;
        };
    }

    @Override
    default Class<Testemunhas> getClazz() {
        return Testemunhas.class;
    }
}
