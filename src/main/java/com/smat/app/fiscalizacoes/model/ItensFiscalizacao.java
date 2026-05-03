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
@Table(name = "itensfiscalizacao", schema = "smat")
public class ItensFiscalizacao {
    @Id
    @Column(name = "itemfiscalizacao")
    private Integer itemFiscalizacao;
    @Column(name = "nome")
    private String nome;
}
