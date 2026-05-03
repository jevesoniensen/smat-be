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
@Table(name = "grupos", schema = "smat")
public class GrupoView {

    @Id
    private int 	grupo;
    private String  nome;
    //private boolean atualiza;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "gruposmodulos",
            schema = "smat",
            joinColumns = @JoinColumn(name = "grupo"),
            inverseJoinColumns = @JoinColumn(name = "modulo")
    )
    private Set<ModuloView> modulos;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuariosgrupos",
            schema = "smat",
            joinColumns = @JoinColumn(name = "grupo"),
            inverseJoinColumns = @JoinColumn(name = "usuario")
    )
    private Set<UsuarioView> usuarios;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "modulos", schema = "smat")
    public static class ModuloView {

        @Id
        private int modulo;

        @Column(name = "paginadefault")
        private Integer paginaDefault;

        private String nome;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "modulopai")
        private ModuloView moduloPai;

        private String estrutura;

        @JsonBackReference // This side is ignored during serialization
        @ManyToMany(mappedBy = "modulos", fetch = FetchType.EAGER)
        private Set<GrupoView> grupos;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "usuarios", schema = "smat")
    public static class UsuarioView {

        @Id
        private int usuario;
        private String nome;
        private String senha;
        private Integer agentesaude;

        @JsonBackReference // This side is ignored during serialization
        @ManyToMany(mappedBy = "usuarios", fetch = FetchType.EAGER)
        private Set<GrupoView> grupos;
    }
}
