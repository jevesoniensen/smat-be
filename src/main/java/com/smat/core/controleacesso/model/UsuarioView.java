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
@Table(name = "usuarios", schema = "smat")
public class UsuarioView {

    @Id
    private int usuario;
    private String nome;
    private String senha;
    private Integer agentesaude;

    @ManyToMany(mappedBy = "usuarios", fetch = FetchType.EAGER)
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
                name = "usuariosgrupos",
                schema = "smat",
                joinColumns = @JoinColumn(name = "grupo"),
                inverseJoinColumns = @JoinColumn(name = "usuario")
        )
        private Set<UsuarioView> usuarios;
    }
}
