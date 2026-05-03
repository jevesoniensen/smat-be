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
@Table(name = "agentessaude", schema = "smat")
public class AgentesSaude {
    @Id
    @Column(name = "agentesaude")
    private Integer agenteSaude;
    @Column(name = "regional")
    private Integer regional;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
}
