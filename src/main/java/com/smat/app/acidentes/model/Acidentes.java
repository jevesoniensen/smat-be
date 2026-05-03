package com.smat.app.acidentes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "acidentes", schema = "smat")
public class Acidentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acidente")
    private Integer acidente;
    @Column(name = "area")
    private Integer area;
    @Column(name = "vinculoempregaticio")
    private Integer vinculoEmpregaticio;
    @Column(name = "ocupacao")
    private Integer ocupacao;
    @Column(name = "localatendimento")
    private Integer localAtendimento;
    @Column(name = "empregador")
    private Integer empregador;
    @Column(name = "medico")
    private Integer medico;
    @Column(name = "diagnostico")
    private Integer diagnostico;
    @Column(name = "fonte")
    private Integer fonte;
    @Column(name = "agentecausador")
    private Integer agenteCausador;
    @Column(name = "tipolocalacidente")
    private Integer tipoLocalAcidente;
    @Column(name = "trabalhador")
    private Integer trabalhador;
    @Column(name = "empregadorterceiro")
    private Integer empregadorTerceiro;
    @Column(name = "tipoacidente")
    private Integer tipoAcidente;
    @Column(name = "emitente")
    private Integer emitente;
    @Column(name = "municipio")
    private Integer municipio;
    @Column(name = "dataacidente")
    private LocalDateTime dataAcidente;
    @Column(name = "registropolicial")
    private String registroPolicial;
    @Column(name = "amputacao")
    private String amputacao;
    @Column(name = "obito")
    private String obito;
    @Column(name = "horastrabalhadas")
    private Integer horasTrabalhadas;
    @Column(name = "desclocalacidente")
    private String descLocalAcidente;
    @Column(name = "numdocfonte")
    private String numDocFonte;
    @Column(name = "dataemissaofonte")
    private LocalDateTime dataEmissaoFonte;
    @Column(name = "naturezalesao")
    private String naturezaLesao;
    @Column(name = "datahoradiagnostico")
    private LocalDateTime dataHoraDiagnostico;
    @Column(name = "afastamento")
    private String afastamento;
    @Column(name = "internacao")
    private String internacao;
    @Column(name = "observacaodiagnostico")
    private String observacaoDiagnostico;
    @Column(name = "duracaotratamento")
    private Integer duracaoTratamento;
    @Column(name = "aposentado")
    private String aposentado;
    @Column(name = "remuneracao")
    private BigDecimal remuneracao;
    @Column(name = "distritosaude")
    private String distritoSaude;
    @Column(name = "ultimatrabalhado")
    private LocalDateTime ultimaTrabalhado;
    @Column(name = "descricaosituacaogeradora")
    private String descricaoSituacaoGeradora;
    @Column(name = "descricaodiagnostico")
    private String descricaoDiagnostico;
}
