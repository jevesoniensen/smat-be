package com.smat.app.parametros.model.acidente;

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
@Table(name = "agentescausadores", schema = "smat")
public class AgentesCausadores {
    @Id
    @Column(name = "agentecausador")
    private Integer id;
    @Column(name = "agentecausadorpai")
    private Integer paiId;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
}
