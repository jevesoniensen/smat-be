package com.smat.core.controleacesso.model;

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
@Table(name = "modulos", schema = "smat")
public class Modulo {

    @Id
    private int modulo;

    @Column(name = "paginadefault")
    private Integer paginaDefault;

    private String nome;

    private Integer modulopai;

    private String estrutura;
}
