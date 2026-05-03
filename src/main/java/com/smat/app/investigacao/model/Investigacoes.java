package com.smat.app.investigacao.model;

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
@Table(name = "investigacoes", schema = "smat")
public class Investigacoes {
    @Id
    @Column(name = "investigacao")
    private Integer investigacao;
    @Column(name = "agentesaude")
    private Integer agenteSaude;
    @Column(name = "acidente")
    private Integer acidente;
    @Column(name = "dataabertura")
    private LocalDateTime dataAbertura;
    @Column(name = "datafinalizacao")
    private LocalDateTime dataFinalizacao;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "obsgerais")
    private String obsGerais;
}
