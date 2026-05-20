package com.smat.app.acidentes.dto;

public record TestemunhaDto(Integer municipio,
                            String nome,
                            Integer numero,
                            String rua,
                            String bairro,
                            String cep,
                            String complemento,
                            String telefone,
                            String ddd
) {
}
