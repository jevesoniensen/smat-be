package com.smat.app.investigacao.model;

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
@Table(name = "medidasCorretivasInvestigacao", schema = "smat")
public class MedidasCorretivasInvestigacao {
    @Id
    @Column(name = "investigacao")
    private Integer investigacao;
    @Column(name = "tipomedidacorretiva")
    private Integer tipoMedidaCorretiva;
    @Column(name = "prazodias")
    private Integer prazoDias;
    @Column(name = "observacao")
    private String observacao;
}
