package com.smat.app.acidentes.model;

import jakarta.persistence.*;
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
    @EmbeddedId
    private LocaisLesaoAcidentesId id;

    public LocaisLesaoAcidentes(Integer acidente, Integer localLesao) {
        this.id = new LocaisLesaoAcidentesId(acidente, localLesao);
    }
}
