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
@Table(name = "materiaisssolicitados", schema = "smat")
public class MateriaisSolicitados {
    @Id
    @Column(name = "planopreventivo")
    private Integer planoPreventivo;
    @Column(name = "materialpreventivo")
    private Integer materialPreventivo;
    @Column(name = "quantidadeobservacao")
    private Integer quantidadeObservacao;
}
