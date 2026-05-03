package com.smat.app.parametros.model.common;

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
@Table(name = "municipios", schema = "smat")
public class Municipios {
    @Id
    @Column(name = "municipio")
    private Integer id;
    @Column(name = "regional")
    private Integer regional;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sigla")
    private String sigla;
    @Column(name = "populacao")
    private Integer populacao;
}
