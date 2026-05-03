package com.smat.app.empresas.model;

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
@Table(name = "telefonesempregadores", schema = "smat")
public class TelefonesEmpregadores {

    @Id
    @Column(name = "telefoneempregador")
    private Integer id;

    @Column(name = "empregador")
    private Integer empregador;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "numero")
    private String numero;

    @Column(name = "ddd")
    private String ddd;
}
