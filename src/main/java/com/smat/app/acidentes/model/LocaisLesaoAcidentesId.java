package com.smat.app.acidentes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LocaisLesaoAcidentesId implements Serializable {
    @Column(name = "acidente")
    private Integer acidente;

    @Column(name = "locallesao")
    private Integer localLesao;
}
