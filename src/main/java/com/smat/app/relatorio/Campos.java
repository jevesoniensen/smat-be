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
@Table(name = "campos", schema = "smat")
public class Campos {
    @Id
    @Column(name = "campo")
    private int campo;
    @Column(name = "tabela")
    private String tabela;
    @Column(name = "coluna")
    private String coluna;
    @Column(name = "pai")
    private String pai;
    @Column(name = "nome")
    private String nome;
    @Column(name = "label")
    private String label;
}
