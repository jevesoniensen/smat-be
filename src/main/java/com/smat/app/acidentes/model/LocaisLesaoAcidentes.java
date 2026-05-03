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
@Table(name = "locaislesaoacidentes", schema = "smat")
public class LocaisLesaoAcidentes {
    @Id
    @Column(name = "acidente")
    private Integer acidente;
    @Column(name = "locallesao")
    private Integer localLesao;
}
