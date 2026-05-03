package com.smat.app.parametros.model.common;

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
@Table(name = "vinculosempregaticios", schema = "smat")
public class VinculosEmpregaticios {
    @Id
    @Column(name = "vinculoempregaticio")
    private Integer id;
    @Column(name = "nome")
    private String nome;
}
