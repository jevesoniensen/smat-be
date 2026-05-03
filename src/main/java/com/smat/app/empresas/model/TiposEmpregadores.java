package com.smat.app.empresas.model;

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
@Table(name = "tiposempregadores", schema = "smat")
public class TiposEmpregadores {

    @Id
    @Column(name = "tipoempregador")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "docidentificador")
    private String docIdentificador;
}
