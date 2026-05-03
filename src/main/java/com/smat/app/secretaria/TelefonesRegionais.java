package com.smat.app.secretaria;

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
@Table(name = "telefonesregionais", schema = "smat")
public class TelefonesRegionais {
    @Id
    @Column(name = "telefoneregional")
    private Integer telefoneRegional;
    @Column(name = "regional")
    private Integer regional;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "numero")
    private String numero;
    @Column(name = "ddd")
    private String ddd;
}
