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
@Table(name = "fiscalizacoes", schema = "smat")
public class Fiscalizacoes {
    @Id
    @Column(name = "fiscalizacao")
    private Integer fiscalizacao;
    @Column(name = "agentesaude")
    private Integer agenteSaude;
    @Column(name = "empregador")
    private Integer empregador;
    @Column(name = "dataabertura")
    private LocalDateTime dataAbertura;
    @Column(name = "datafinalizacao")
    private LocalDateTime dataFinalizacao;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "obsgerais")
    private String obsGerais;
}
