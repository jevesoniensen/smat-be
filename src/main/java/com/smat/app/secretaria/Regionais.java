package com.smat.app.secretaria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "regionais", schema = "smat")
public class Regionais {
    @Id
    @Column(name = "regional")
    private Integer regional;
    @Column(name = "municipio")
    private Integer municipio;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "nome")
    private String nome;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "rua")
    private String rua;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "complemento")
    private String complemento;
}
