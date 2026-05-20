package com.smat.app.acidentes.model;

import jakarta.persistence.*;
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
@Table(name = "trabalhadores", schema = "smat")
public class Trabalhadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trabalhador")
    private Integer trabalhador;
    @Column(name = "municipio")
    private Integer municipio;
    @Column(name = "ufrg")
    private Integer UFRG;
    @Column(name = "ufctps")
    private Integer UFCTPS;
    @Column(name = "estadocivil")
    private Integer estadoCivil;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rg")
    private String rg;
    @Column(name = "carteiratrabalho")
    private Integer carteiraTrabalho;
    @Column(name = "serie")
    private Integer serie;
    @Column(name = "dataemissaoctps")
    private LocalDateTime dataEmissaoCTPS;
    @Column(name = "datanascimento")
    private LocalDateTime dataNascimento;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "rua")
    private String rua;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "nomeresponsavel")
    private String nomeResponsavel;
    @Column(name = "dataemissaorg")
    private LocalDateTime dataEmissaoRG;
    @Column(name = "orgaoexpedidorrg")
    private String orgaoExpedidorRG;
    @Column(name = "pispasepnit")
    private String PISPASEPNIT;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "ddd")
    private String ddd;
}
