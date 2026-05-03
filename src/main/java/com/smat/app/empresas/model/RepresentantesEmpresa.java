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
@Table(name = "representantesempresa", schema = "smat")
public class RepresentantesEmpresa {

    @Id
    @Column(name = "representanteempresa")
    private Integer id;

    @Column(name = "empregador")
    private Integer empregador;

    @Column(name = "nome")
    private String nome;
}
