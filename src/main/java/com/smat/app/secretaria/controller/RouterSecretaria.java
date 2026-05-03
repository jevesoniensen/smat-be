package com.smat.app.secretaria.controller;

import com.smat.app.secretaria.repository.AgentesSaudeRepository;
import com.smat.app.secretaria.repository.RegionaisRepository;
import com.smat.app.secretaria.repository.TelefonesRegionaisRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.smat.common.route.Router.routeCRUD;

@Configuration(proxyBeanMethods = false)
public class RouterSecretaria {

    public static final String TAG = "Secretaria";

    @Bean
    public RouterFunction<ServerResponse> routeRegionais(RegionaisRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeAgentesSaude(AgentesSaudeRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeTelefonesRegionais(TelefonesRegionaisRepository repository) {
        return routeCRUD(TAG, repository);
    }
}

