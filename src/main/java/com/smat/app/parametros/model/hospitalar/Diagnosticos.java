package com.smat.app.parametros.model.hospitalar;

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
@Table(name = "diagnosticos", schema = "smat")
public class Diagnosticos {
    @Id
    @Column(name = "diagnostico")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cid10")
    private Integer cid10;
}
