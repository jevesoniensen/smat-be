package com.smat.app.relatorio.controller;

import com.smat.app.relatorio.repository.CamposRepository;
import com.smat.app.relatorio.repository.LocaisRepository;
import com.smat.app.relatorio.repository.RelatoriosRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.smat.common.route.Router.routeCRUD;

@Configuration(proxyBeanMethods = false)
public class RouterRelatorio {

    public static final String TAG = "Relatorio";

    @Bean
    public RouterFunction<ServerResponse> routeCampos(CamposRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeLocais(LocaisRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeRelatorios(RelatoriosRepository repository) {
        return routeCRUD(TAG, repository);
    }
}

