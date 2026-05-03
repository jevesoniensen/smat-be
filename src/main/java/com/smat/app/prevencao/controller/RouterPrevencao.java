package com.smat.app.prevencao.controller;

import com.smat.app.prevencao.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.smat.common.route.Router.routeCRUD;

@Configuration(proxyBeanMethods = false)
public class RouterPrevencao {

    public static final String TAG = "Prevencao";

    @Bean
    public RouterFunction<ServerResponse> routeMateriaisPreventivos(MateriaisPreventivosRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeMateriaisSolicitados(MateriaisSolicitadosRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routePlanosPreventivos(PlanosPreventivosRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeResultadosPrevencao(ResultadosPrevencaoRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeTreinamentos(TreinamentosRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeTreinamentos_PlanosPreventivos(TreinamentosPlanosPreventivosRepository repository) {
        return routeCRUD(TAG, repository);
    }
}

