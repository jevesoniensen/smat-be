package com.smat.app.acidentes.model;

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
@Table(name = "tiposmedidascorretivas", schema = "smat")
public class TiposMedidasCorretivas {
    @Id
    @Column(name = "tiposmedidascorretivas")
    private Integer tipoMedidaCorretiva;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
}
