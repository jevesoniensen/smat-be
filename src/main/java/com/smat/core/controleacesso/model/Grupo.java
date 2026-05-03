package com.smat.core.controleacesso.model;

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
public class Grupo {

    @Id
    private int 	grupo;
    private String  nome;
    //private boolean atualiza;
}
