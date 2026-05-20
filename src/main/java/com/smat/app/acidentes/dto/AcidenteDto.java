package com.smat.app.acidentes.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


public record AcidenteDto (    Integer area,
                               Integer vinculoEmpregaticio,
                               Integer ocupacao,
                               Integer localAtendimento,
                               Integer empregador,
                               Integer medico,
                               Integer diagnostico,
                               Integer fonte,
                               Integer agenteCausador,
                               Integer tipoLocalAcidente,
                               TrabalhadorDto trabalhador,
                               Integer empregadorTerceiro,
                               Integer tipoAcidente,
                               Integer emitente,
                               Integer municipio,
                               LocalDateTime dataAcidente,
                               String registroPolicial,
                               String amputacao,
                               String obito,
                               Integer horasTrabalhadas,
                               String descLocalAcidente,
                               String numDocFonte,
                               LocalDateTime dataEmissaoFonte,
                               String naturezaLesao,
                               LocalDateTime dataHoraDiagnostico,
                               String afastamento,
                               String internacao,
                               String observacaoDiagnostico,
                               Integer duracaoTratamento,
                               String aposentado,
                               BigDecimal remuneracao,
                               String distritoSaude,
                               LocalDateTime ultimaTrabalhado,
                               String descricaoSituacaoGeradora,
                               String descricaoDiagnostico,
                               List<TestemunhaDto> testemunhas,
                               Set<Integer> locaisLesaoAcidentes
) {

}
