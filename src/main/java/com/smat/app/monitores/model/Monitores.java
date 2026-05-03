package com.smat.app.monitores.model;

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
@Table(name = "monitores", schema = "smat")
public class Monitores {
    @Id
    @Column(name = "monitor")
    private Integer monitor;
    @Column(name = "periodicidade")
    private Integer periodicidade;
    @Column(name = "campo")
    private Integer campo;
    @Column(name = "maxacidente")
    private Integer maxAcidente;
    @Column(name = "ultimadataexecucao")
    private LocalDateTime ultimaDataExecucao;
    @Column(name = "querycampo")
    private Integer queryCampo;
}
