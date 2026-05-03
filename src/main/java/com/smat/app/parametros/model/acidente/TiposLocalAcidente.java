package com.smat.app.parametros.model.acidente;

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
@Table(name = "tiposlocalacidente", schema = "smat")
public class TiposLocalAcidente {
    @Id
    @Column(name = "tipolocalacidente")
    private Integer id;
    @Column(name = "nome")
    private String nome;
}
