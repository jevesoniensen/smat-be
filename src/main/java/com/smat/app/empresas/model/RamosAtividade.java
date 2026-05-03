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
@Table(name = "ramosatividade", schema = "smat")
public class RamosAtividade {

    @Id
    @Column(name = "ramoatividade")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cnae")
    private Integer cnae;

    @Column(name = "ramosuperior")
    private Integer ramoSuperior;
}
