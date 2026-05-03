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
@Table(name = "dadosinvestigacao", schema = "smat")
public class DadosInvestigacao {
    @Id
    @Column(name = "investigacao")
    private Integer investigacao;
    @Column(name = "dadoinvestigacao")
    private Integer dadoInvestigacao;
    @Column(name = "tipodepoimento")
    private Integer tipodepoimento;
    @Column(name = "representanteempresa")
    private Integer representanteEmpresa;
    @Column(name = "testemunha")
    private Integer testemunha;
    @Column(name = "agentesaude")
    private Integer agenteSaude;
    @Column(name = "datahora")
    private LocalDateTime dataHora;
    @Column(name = "agentecausador")
    private Integer agenteCausador;
    @Column(name = "trabalhador")
    private Integer trabalhador;
    @Column(name = "descricao")
    private String descricao;
}
