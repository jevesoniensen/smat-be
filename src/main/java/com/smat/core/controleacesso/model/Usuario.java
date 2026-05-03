package com.smat.core.controleacesso.model;

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
@Table(name = "usuarios", schema = "smat")
public class Usuario {

    @Id
    private int usuario;
    private String nome;
    private String senha;
    private Integer agentesaude;
}
