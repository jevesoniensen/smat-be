package com.smat.core.controleacesso.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "modulos", schema = "smat")
public class ModuloView {

    @Id
    private int modulo;

    @Column(name = "paginadefault")
    private Integer paginaDefault;

    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modulopai")
    private ModuloView moduloPai;

    private String estrutura;

    @ManyToMany(mappedBy = "modulos", fetch = FetchType.EAGER)
    private Set<GrupoView> grupos;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "grupos", schema = "smat")
    public static class GrupoView {

        @Id
        private int 	grupo;
        private String  nome;

        @JsonBackReference // This side is ignored during serialization
        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(
                name = "gruposmodulos",
                schema = "smat",
                joinColumns = @JoinColumn(name = "grupo"),
                inverseJoinColumns = @JoinColumn(name = "modulo")
        )
        private Set<ModuloView> modulos;
    }
}
