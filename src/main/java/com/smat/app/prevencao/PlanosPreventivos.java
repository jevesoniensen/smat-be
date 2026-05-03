package com.smat.app.prevencao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "planospreventivos", schema = "smat")
public class PlanosPreventivos {
    @Id
    @Column(name = "planopreventivo")
    private Integer planoPreventivo;
    @Column(name = "regional")
    private Integer regional;
    @Column(name = "resultadoprevencao")
    private Integer resultadoPrevencao;
    @Column(name = "dataabertura")
    private LocalDateTime dataAbertura;
    @Column(name = "datafinalizacao")
    private LocalDateTime dataFinalizacao;
    @Column(name = "titulo")
    private String titulo;
}
