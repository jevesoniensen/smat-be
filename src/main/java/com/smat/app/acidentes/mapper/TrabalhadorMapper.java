package com.smat.app.acidentes.mapper;

import com.smat.app.acidentes.dto.TrabalhadorDto;
import com.smat.app.acidentes.model.Trabalhadores;
import org.springframework.stereotype.Component;

@Component
public class TrabalhadorMapper {

    public Trabalhadores toEntity(TrabalhadorDto dto) {
        if (dto == null) {
            return null;
        }
        Trabalhadores entity = new Trabalhadores();
        entity.setMunicipio(dto.municipio());
        entity.setUFRG(dto.UFRG());
        entity.setUFCTPS(dto.UFCTPS());
        entity.setEstadoCivil(dto.estadoCivil());
        entity.setNome(dto.nome());
        entity.setCpf(dto.cpf());
        entity.setRg(dto.rg());
        entity.setCarteiraTrabalho(dto.carteiraTrabalho());
        entity.setSerie(dto.serie());
        entity.setDataEmissaoCTPS(dto.dataEmissaoCTPS());
        entity.setDataNascimento(dto.dataNascimento());
        entity.setSexo(dto.sexo());
        entity.setNumero(dto.numero());
        entity.setRua(dto.rua());
        entity.setBairro(dto.bairro());
        entity.setCep(dto.cep());
        entity.setComplemento(dto.complemento());
        entity.setNomeResponsavel(dto.nomeResponsavel());
        entity.setDataEmissaoRG(dto.dataEmissaoRG());
        entity.setOrgaoExpedidorRG(dto.orgaoExpedidorRG());
        entity.setPISPASEPNIT(dto.PISPASEPNIT());
        entity.setTelefone(dto.telefone());
        entity.setDdd(dto.ddd());
        return entity;
    }

    public TrabalhadorDto toDto(Trabalhadores entity) {
        if (entity == null) {
            return null;
        }
        return new TrabalhadorDto(
                entity.getMunicipio(),
                entity.getUFRG(),
                entity.getUFCTPS(),
                entity.getEstadoCivil(),
                entity.getNome(),
                entity.getCpf(),
                entity.getRg(),
                entity.getCarteiraTrabalho(),
                entity.getSerie(),
                entity.getDataEmissaoCTPS(),
                entity.getDataNascimento(),
                entity.getSexo(),
                entity.getNumero(),
                entity.getRua(),
                entity.getBairro(),
                entity.getCep(),
                entity.getComplemento(),
                entity.getNomeResponsavel(),
                entity.getDataEmissaoRG(),
                entity.getOrgaoExpedidorRG(),
                entity.getPISPASEPNIT(),
                entity.getTelefone(),
                entity.getDdd()
        );
    }
}
