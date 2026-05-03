package com.smat.app.relatorio;

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
@Table(name = "locais", schema = "smat")
public class Locais {
    @Id
    @Column(name = "local")
    private Integer local;
    @Column(name = "tabela")
    private String tabela;
    @Column(name = "coluna")
    private String coluna;
    @Column(name = "label")
    private String label;
    @Column(name = "colunanome")
    private String colunanome;
}
