package com.smat.app.acidentes.repository;

import com.smat.app.acidentes.model.Trabalhadores;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhadorasRepository extends JpaRepositoryExtended<Trabalhadores, Integer> {
    @Override
    default Updater<Trabalhadores> getUpdater() {
        return (body, entity) -> {
            entity.setMunicipio(body.getMunicipio());
            entity.setUFRG(body.getUFRG());
            entity.setUFCTPS(body.getUFCTPS());
            entity.setEstadoCivil(body.getEstadoCivil());
            entity.setNome(body.getNome());
            entity.setCpf(body.getCpf());
            entity.setRg(body.getRg());
            entity.setCarteiraTrabalho(body.getCarteiraTrabalho());
            entity.setSerie(body.getSerie());
            entity.setDataEmissaoCTPS(body.getDataEmissaoCTPS());
            entity.setDataNascimento(body.getDataNascimento());
            entity.setSexo(body.getSexo());
            entity.setNumero(body.getNumero());
            entity.setRua(body.getRua());
            entity.setBairro(body.getBairro());
            entity.setCep(body.getCep());
            entity.setComplemento(body.getComplemento());
            entity.setNomeResponsavel(body.getNomeResponsavel());
            entity.setDataEmissaoRG(body.getDataEmissaoRG());
            entity.setOrgaoExpedidorRG(body.getOrgaoExpedidorRG());
            entity.setPISPASEPNIT(body.getPISPASEPNIT());
            entity.setTelefone(body.getTelefone());
            entity.setDdd(body.getDdd());
            return entity;
        };
    }

    @Override
    default Class<Trabalhadores> getClazz() {
        return Trabalhadores.class;
    }
}
