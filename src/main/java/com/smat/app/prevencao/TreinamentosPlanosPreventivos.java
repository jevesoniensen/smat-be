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
@Table(name = "treinamentosplanospreventivos", schema = "smat")
public class TreinamentosPlanosPreventivos {
    @Id
    @Column(name = "treinamento")
    private Integer treinamento;
    @Column(name = "planopreventivo")
    private Integer planoPreventivo;
}
