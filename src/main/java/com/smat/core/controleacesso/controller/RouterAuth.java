package com.smat.core.controleacesso.controller;

import com.smat.core.controleacesso.controller.handler.OAuth;
import com.smat.core.controleacesso.dto.LoginRequest;
import com.smat.core.controleacesso.dto.LoginResponse;
import com.smat.core.controleacesso.dto.MenuItem;
import com.smat.core.controleacesso.dto.Usuario;
import lombok.RequiredArgsConstructor;
import org.springdoc.webflux.core.fn.SpringdocRouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.List;
import java.util.function.Consumer;

import static com.smat.common.route.Router.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
public class RouterAuth {

    public static final String TAG = "auth";

    private final OAuth oAuth;

    @Bean
    public RouterFunction<ServerResponse> routeAuth() {
        return routeBuilder(
                List.of(
                        getCurrentUser(),
                        getMenuItem(),
                        login(),
                        logout()
                )
        );
    }

    public <T> Consumer<SpringdocRouteBuilder> getMenuItem() {
        return route -> route.GET(
                "/api/auth/menu",
                accept(APPLICATION_JSON), oAuth::loadMenuItem,
                ops -> getResponse(
                        ops,
                        MenuItem.class,
                        "OAuth",
                        "getMenuItem", "200", "Menu item")
        );
    }

    public <T> Consumer<SpringdocRouteBuilder> getCurrentUser() {
        return route -> route.GET(
                "/api/auth/current-user",
                accept(APPLICATION_JSON), oAuth::currentUserGetHandler,
                ops -> getResponse(
                        ops,
                        Usuario.class,
                        "OAuth",
                        "getCurrentUser", "200", "Current user data")
        );
    }

    public <T> Consumer<SpringdocRouteBuilder> login() {
        return route -> route.POST(
                "/api/auth/login",
                accept(APPLICATION_JSON), oAuth::login,
                ops -> getChangeOperation(ops, LoginRequest.class, LoginResponse.class, TAG, "create", "200")
        );
    }

    public <T> Consumer<SpringdocRouteBuilder> logout() {
        return route -> route.POST(
                "/api/auth/logout",
                accept(APPLICATION_JSON), oAuth::logout,
                ops -> getChangeOperation(ops, Void.class, Void.class, TAG, "create", "200")
        );
    }
}
