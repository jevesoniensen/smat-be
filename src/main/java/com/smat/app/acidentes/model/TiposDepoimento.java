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
@Table(name = "tiposdepoimento", schema = "smat")
public class TiposDepoimento {
    @Id
    @Column(name = "tipodepoimento")
    private Integer tipoDepoimento;
    @Column(name = "nome")
    private String nome;
}
