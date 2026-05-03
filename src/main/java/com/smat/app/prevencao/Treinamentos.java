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
@Table(name = "treinamentos", schema = "smat")
public class Treinamentos {
    @Id
    @Column(name = "treinamento")
    private Integer treinamento;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
}
