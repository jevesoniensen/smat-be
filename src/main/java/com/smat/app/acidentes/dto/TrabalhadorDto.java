package com.smat.app.acidentes.dto;

import java.time.LocalDateTime;

public record TrabalhadorDto(Integer municipio,
                             Integer UFRG,
                             Integer UFCTPS,
                             Integer estadoCivil,
                             String nome,
                             String cpf,
                             String rg,
                             Integer carteiraTrabalho,
                             Integer serie,
                             LocalDateTime dataEmissaoCTPS,
                             LocalDateTime dataNascimento,
                             String sexo,
                             Integer numero,
                             String rua,
                             String bairro,
                             String cep,
                             String complemento,
                             String nomeResponsavel,
                             LocalDateTime dataEmissaoRG,
                             String orgaoExpedidorRG,
                             String PISPASEPNIT,
                             String telefone,
                             String ddd) {

}
