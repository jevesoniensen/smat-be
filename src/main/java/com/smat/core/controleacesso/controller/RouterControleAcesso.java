package com.smat.core.controleacesso.controller;

import com.smat.core.controleacesso.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.smat.common.route.Router.routeCRUD;
import static com.smat.common.route.Router.routeView;


@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
public class RouterControleAcesso {

    public static final String TAG = "Controle de acessos";

    @Bean
    public RouterFunction<ServerResponse> routeGrupo(GrupoRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeGrupoView(GrupoViewRepository repository) {
        return routeView(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeModulo(ModuloRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeModuloView(ModuloViewRepository repository) {
        return routeView(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeUsuario(UsuarioRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeUsuarioView(UsuarioViewRepository repository) {
        return routeView(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routePagina(PaginaRepository repository) {
        return routeCRUD(TAG, repository);
    }
}
