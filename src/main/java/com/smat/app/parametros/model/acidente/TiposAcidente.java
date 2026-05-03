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
@Table(name = "tiposacidente", schema = "smat")
public class TiposAcidente {
    @Id
    @Column(name = "tipoacidente")
    private Integer id;
    @Column(name = "nome")
    private String nome;
}
