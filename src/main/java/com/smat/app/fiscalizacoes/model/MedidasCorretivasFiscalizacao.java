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
@Table(name = "medidasCorretivasFiscalizacao", schema = "smat")
public class MedidasCorretivasFiscalizacao {
    @Id
    @Column(name = "fiscalizacao")
    private Integer fiscalizacao;
    @Column(name = "tramitesfiscalizacao")
    private Integer tramiteFiscalizacao;
    @Column(name = "tipomedidacorretiva")
    private Integer tipoMedidaCorretiva;
    @Column(name = "prazodias")
    private Integer prazoDias;
    @Column(name = "observacao")
    private String observacao;
}
