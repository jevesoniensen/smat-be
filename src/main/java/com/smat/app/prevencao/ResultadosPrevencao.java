package com.smat.app.prevencao;

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
@Table(name = "resultadosprevencao", schema = "smat")
public class ResultadosPrevencao {
    @Id
    @Column(name = "resultadoprevencao")
    private Integer resultadoPrevencao;
    @Column(name = "descricao")
    private String descricao;
}
