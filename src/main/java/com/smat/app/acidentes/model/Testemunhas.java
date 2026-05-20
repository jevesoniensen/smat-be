package com.smat.app.acidentes.model;

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
@Table(name = "testemunhas", schema = "smat")
public class Testemunhas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "testemunha")
    private Integer testemunha;
    @Column(name = "acidente")
    private Integer acidente;
    @Column(name = "municipio")
    private Integer municipio;
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
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "ddd")
    private String ddd;
}
