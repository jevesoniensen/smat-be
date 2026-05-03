package com.smat.app.fiscalizacoes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tramitesfiscalizacao", schema = "smat")
public class TramitesFiscalizacao {
    @Id
    @Column(name = "tramitesfiscalizacao")
    private Integer tramiteFiscalizacao;
    @Column(name = "fiscalizacao")
    private Integer fiscalizacao;
    @Column(name = "status")
    private Integer status;
    @Column(name = "data")
    private LocalDateTime data;
}
