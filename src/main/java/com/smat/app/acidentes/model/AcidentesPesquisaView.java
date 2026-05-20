package com.smat.app.acidentes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "acidentes", schema = "smat")
public class AcidentesPesquisaView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acidente")
    private Integer id;

    @Column(name = "dataacidente")
    private LocalDateTime dataAcidente;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empregador")
    private EmpregadoresView empregador;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trabalhador")
    private TrabalhadoresView trabalhador;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "empregadores", schema = "smat")
    public static class EmpregadoresView {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "empregador")
        private Integer id;
        @Column(name = "razaosocial")
        private String razaoSocial;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "trabalhadores", schema = "smat")
    public static class TrabalhadoresView {
        @Id
        @Column(name = "trabalhador")
        private Integer id;
        @Column(name = "nome")
        private String nome;
    }
}
