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
@Table(name = "medicos", schema = "smat")
public class Medicos {
    @Id
    @Column(name = "medico")
    private Integer medico;
    @Column(name = "ufcrm")
    private Integer ufCRM;
    @Column(name = "nome")
    private String nome;
    @Column(name = "crm")
    private Integer crm;
}
