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
@Table(name = "pontosfiscalizacaoramosatividade", schema = "smat")
public class PontosFiscalizacaoRamosAtividade {
    @Id
    @Column(name = "pontofiscalizacao")
    private Integer pontoFiscalizacao;
    @Column(name = "ramoatividade")
    private Integer ramoAtividade;
}
