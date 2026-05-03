package com.smat.app.prevencao;

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
@Table(name = "materiaispreventivos", schema = "smat")
public class MateriaisPreventivos {
    @Id
    @Column(name = "materialpreventivo")
    private Integer materialPreventivo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
}
