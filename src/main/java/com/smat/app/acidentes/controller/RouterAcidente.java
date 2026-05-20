package com.smat.app.acidentes.controller;

import com.smat.app.acidentes.dto.AcidenteDto;
import com.smat.app.acidentes.repository.*;
import com.smat.app.acidentes.service.AcidenteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.List;

import static com.smat.common.route.Router.*;

@Configuration(proxyBeanMethods = false)
public class RouterAcidente {

    public static final String TAG = "Cadastro";

    @Bean
    public RouterFunction<ServerResponse> routeMedicos(MedicosRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeTestemunhas(TestemunhasRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeGrausConformidade(GrausConformidadeRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeTiposDepoimento(TiposDepoimentoRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeTiposAgrupamento(TiposAgrupamentoRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeTrabalhadores(TrabalhadoresRepository repository) {
        return routeCRUD(TAG, repository);
    }

//    @Bean
//    public RouterFunction<ServerResponse> routeLocaisLesaoAcidentes(LocaisLesaoAcidentesRepository repository) {
//        return routeCRUD(TAG, repository);
//    }

    @Bean
    public RouterFunction<ServerResponse> routeAcidentes(AcidentesRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeTiposMedidasCorretivas(TiposMedidasCorrativasRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeAcidentesExtended(AcidentesPesquisaViewRepository repository,
                                                                 AcidenteService service) {
        return routeBuilder(
                List.of(
                        findAll(TAG, "pesquisa/", repository),
                        create(TAG, "gravar/", AcidenteDto.class, service::create)
//                        findByParams(
//                                TAG,
//                                "pesquisa/" ,
//                                AcidentesPesquisaView.class,
//                                request -> commonHandler(() -> repository.findAll(request.queryParam("razaoSocial").orElseThrow())),
//                                org.springdoc.core.fn.builders.parameter.Builder.parameterBuilder()
//                                        .name("razaoSocial").in(ParameterIn.QUERY).required(true)
//                        )
                )
        );
    }
}
