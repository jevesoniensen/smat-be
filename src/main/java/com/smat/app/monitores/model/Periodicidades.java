package com.smat.app.monitores.model;

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
@Table(name = "periodicidades", schema = "smat")
public class Periodicidades {
    @Id
    @Column(name = "periodicidade")
    private Integer periodicidade;
    @Column(name = "nome")
    private String nome;
}
