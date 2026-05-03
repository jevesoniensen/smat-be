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
@Table(name = "areas", schema = "smat")
public class Areas {

    @Id
    @Column(name = "area")
    private int id;
    @Column(name = "nome")
    private String nome;
}
