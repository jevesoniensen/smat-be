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
@Table(name = "locaisatendimento", schema = "smat")
public class LocaisAtendimento {
    @Id
    @Column(name = "localatendimento")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "municipio")
    private Integer municipio;
}
