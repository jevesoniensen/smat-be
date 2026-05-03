package com.smat.app.acidentes.model;

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
@Table(name = "grausconformidade", schema = "smat")
public class GrausConformidade {
    @Id
    @Column(name = "grauconformidade")
    private Integer grauConformidade;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
}
