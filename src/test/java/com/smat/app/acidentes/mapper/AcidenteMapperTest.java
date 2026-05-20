package com.smat.app.acidentes.mapper;

import com.smat.app.acidentes.dto.AcidenteDto;
import com.smat.app.acidentes.dto.TestemunhaDto;
import com.smat.app.acidentes.dto.TrabalhadorDto;
import com.smat.app.acidentes.model.Acidentes;
import com.smat.app.acidentes.model.Testemunhas;
import com.smat.app.acidentes.model.Trabalhadores;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class AcidenteMapperTest {

    private final AcidenteMapper acidenteMapper = new AcidenteMapper();
    private final TrabalhadorMapper trabalhadorMapper = new TrabalhadorMapper();
    private final TestemunhaMapper testemunhaMapper = new TestemunhaMapper();

    @Test
    void toEntity_shouldMapAllFields() {
        LocalDateTime now = LocalDateTime.now();
        AcidenteDto dto = new AcidenteDto(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                null, 12, 13, 14, 15, now, "reg", "S", "N", 40,
                "desc", "num", now, "nat", now, "af", "int", "obs", 10,
                "S", new BigDecimal("1000.00"), "dist", now, "sit", "diag",
                new ArrayList<>(), new HashSet<>()
        );

        Acidentes entity = acidenteMapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(dto.area(), entity.getArea());
        assertEquals(dto.vinculoEmpregaticio(), entity.getVinculoEmpregaticio());
        assertEquals(dto.ocupacao(), entity.getOcupacao());
        assertEquals(dto.localAtendimento(), entity.getLocalAtendimento());
        assertEquals(dto.empregador(), entity.getEmpregador());
        assertEquals(dto.medico(), entity.getMedico());
        assertEquals(dto.diagnostico(), entity.getDiagnostico());
        assertEquals(dto.fonte(), entity.getFonte());
        assertEquals(dto.agenteCausador(), entity.getAgenteCausador());
        assertEquals(dto.tipoLocalAcidente(), entity.getTipoLocalAcidente());
        assertEquals(dto.empregadorTerceiro(), entity.getEmpregadorTerceiro());
        assertEquals(dto.tipoAcidente(), entity.getTipoAcidente());
        assertEquals(dto.emitente(), entity.getEmitente());
        assertEquals(dto.municipio(), entity.getMunicipio());
        assertEquals(dto.dataAcidente(), entity.getDataAcidente());
        assertEquals(dto.registroPolicial(), entity.getRegistroPolicial());
        assertEquals(dto.amputacao(), entity.getAmputacao());
        assertEquals(dto.obito(), entity.getObito());
        assertEquals(dto.horasTrabalhadas(), entity.getHorasTrabalhadas());
        assertEquals(dto.descLocalAcidente(), entity.getDescLocalAcidente());
        assertEquals(dto.numDocFonte(), entity.getNumDocFonte());
        assertEquals(dto.dataEmissaoFonte(), entity.getDataEmissaoFonte());
        assertEquals(dto.naturezaLesao(), entity.getNaturezaLesao());
        assertEquals(dto.dataHoraDiagnostico(), entity.getDataHoraDiagnostico());
        assertEquals(dto.afastamento(), entity.getAfastamento());
        assertEquals(dto.internacao(), entity.getInternacao());
        assertEquals(dto.observacaoDiagnostico(), entity.getObservacaoDiagnostico());
        assertEquals(dto.duracaoTratamento(), entity.getDuracaoTratamento());
        assertEquals(dto.aposentado(), entity.getAposentado());
        assertEquals(dto.remuneracao(), entity.getRemuneracao());
        assertEquals(dto.distritoSaude(), entity.getDistritoSaude());
        assertEquals(dto.ultimaTrabalhado(), entity.getUltimaTrabalhado());
        assertEquals(dto.descricaoSituacaoGeradora(), entity.getDescricaoSituacaoGeradora());
        assertEquals(dto.descricaoDiagnostico(), entity.getDescricaoDiagnostico());
    }

    @Test
    void toEntityTrabalhador_shouldMapAllFields() {
        LocalDateTime now = LocalDateTime.now();
        TrabalhadorDto dto = new TrabalhadorDto(
                1, 2, 3, 4, "Nome", "123", "456", 7, 8, now, now, "M", 9,
                "Rua", "Bairro", "CEP", "Comp", "Resp", now, "Exp", "PIS", "Tel", "00"
        );

        Trabalhadores entity = trabalhadorMapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(dto.municipio(), entity.getMunicipio());
        assertEquals(dto.UFRG(), entity.getUFRG());
        assertEquals(dto.UFCTPS(), entity.getUFCTPS());
        assertEquals(dto.estadoCivil(), entity.getEstadoCivil());
        assertEquals(dto.nome(), entity.getNome());
        assertEquals(dto.cpf(), entity.getCpf());
        assertEquals(dto.rg(), entity.getRg());
        assertEquals(dto.carteiraTrabalho(), entity.getCarteiraTrabalho());
        assertEquals(dto.serie(), entity.getSerie());
        assertEquals(dto.dataEmissaoCTPS(), entity.getDataEmissaoCTPS());
        assertEquals(dto.dataNascimento(), entity.getDataNascimento());
        assertEquals(dto.sexo(), entity.getSexo());
        assertEquals(dto.numero(), entity.getNumero());
        assertEquals(dto.rua(), entity.getRua());
        assertEquals(dto.bairro(), entity.getBairro());
        assertEquals(dto.cep(), entity.getCep());
        assertEquals(dto.complemento(), entity.getComplemento());
        assertEquals(dto.nomeResponsavel(), entity.getNomeResponsavel());
        assertEquals(dto.dataEmissaoRG(), entity.getDataEmissaoRG());
        assertEquals(dto.orgaoExpedidorRG(), entity.getOrgaoExpedidorRG());
        assertEquals(dto.PISPASEPNIT(), entity.getPISPASEPNIT());
        assertEquals(dto.telefone(), entity.getTelefone());
        assertEquals(dto.ddd(), entity.getDdd());
    }

    @Test
    void toEntityTestemunha_shouldMapAllFields() {
        TestemunhaDto dto = new TestemunhaDto(
                1, "Nome", 2, "Rua", "Bairro", "CEP", "Comp", "Tel", "00"
        );

        Testemunhas entity = testemunhaMapper.toEntity(99, dto);

        assertNotNull(entity);
        assertEquals(99, entity.getAcidente());
        assertEquals(dto.municipio(), entity.getMunicipio());
        assertEquals(dto.nome(), entity.getNome());
        assertEquals(dto.numero(), entity.getNumero());
        assertEquals(dto.rua(), entity.getRua());
        assertEquals(dto.bairro(), entity.getBairro());
        assertEquals(dto.cep(), entity.getCep());
        assertEquals(dto.complemento(), entity.getComplemento());
        assertEquals(dto.telefone(), entity.getTelefone());
        assertEquals(dto.ddd(), entity.getDdd());
    }
}
