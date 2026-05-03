package com.smat.app.relatorio;

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
@Table(name = "relatorios", schema = "smat")
public class Relatorios {
    @Id
    @Column(name = "relatorio")
    private Integer relatorio;
    @Column(name = "tipoagrupamento")
    private Integer tipoAgrupamento;
    @Column(name = "local")
    private Integer local;
    @Column(name = "querylocal")
    private String queryLocal;
    @Column(name = "periodicidade")
    private Integer periodicidade;
    @Column(name = "campo1")
    private Integer campo1;
    @Column(name = "querycampo1")
    private String queryCampo1;
    @Column(name = "campo2")
    private Integer campo2;
    @Column(name = "querycampo2")
    private String queryCampo2;
    @Column(name = "datainicio")
    private LocalDateTime dataInicio;
    @Column(name = "datafim")
    private LocalDateTime dataFim;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "texto")
    private String texto;
    @Column(name = "datacriacao")
    private LocalDateTime dataCriacao;
}
