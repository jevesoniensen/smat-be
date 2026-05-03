package com.smat.app.fiscalizacoes.model;

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
@Table(name = "roteiros", schema = "smat")
public class Roteiros {
    @Id
    @Column(name = "tramitesfiscalizacao")
    private Integer tramiteFiscalizacao;
    @Column(name = "fiscalizacao")
    private Integer fiscalizacao;
    @Column(name = "itemfiscalizacao")
    private Integer itemFiscalizacao;
    @Column(name = "grauconformidade")
    private Integer grauConformidade;
    @Column(name = "nome")
    private String nome;
}
