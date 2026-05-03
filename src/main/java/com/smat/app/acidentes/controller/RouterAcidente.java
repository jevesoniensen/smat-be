package com.smat.app.acidentes.controller;

import com.smat.app.acidentes.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.smat.common.route.Router.routeCRUD;

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
    public RouterFunction<ServerResponse> routeTrabalhadores(TrabalhadorasRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeLocaisLesaoAcidentes(LocaisLesaoAcidentesRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeAcidentes(AcidentesRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeTiposMedidasCorretivas(TiposMedidasCorrativasRepository repository) {
        return routeCRUD(TAG, repository);
    }
}
