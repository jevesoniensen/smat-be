package com.smat.app.monitores.controller;

import com.smat.app.monitores.repository.MonitoresRepository;
import com.smat.app.monitores.repository.PeriodicidadesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.smat.common.route.Router.routeCRUD;

@Configuration(proxyBeanMethods = false)
public class RouterMonitores {

    public static final String TAG = "Monitores";

    @Bean
    public RouterFunction<ServerResponse> routeMonitores(MonitoresRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routePeriodicidades(PeriodicidadesRepository repository) {
        return routeCRUD(TAG, repository);
    }
}

