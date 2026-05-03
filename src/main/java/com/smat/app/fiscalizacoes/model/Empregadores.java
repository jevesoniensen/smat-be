package com.smat.app.fiscalizacoes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empregadores", schema = "smat")
public class Empregadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empregador")
    private Integer id;
    @Column(name = "ramoatividade")
    private Integer ramoAtividade;
    @Column(name = "estado")
    private String estado;
    @Column(name = "municipio")
    private Integer municipio;
    @Column(name = "tipoempregador")
    private Integer tipoEmpregador;
    @Column(name = "razaosocial")
    private String razaoSocial;
    @Column(name = "documento")
    private String documento;
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
