package com.smat.core.controleacesso.controller.handler;

import com.smat.core.controleacesso.dto.LoginRequest;
import com.smat.core.controleacesso.dto.LoginResponse;
import com.smat.core.controleacesso.dto.MenuItem;
import com.smat.core.controleacesso.dto.Usuario;
import com.smat.core.controleacesso.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class OAuth {

    private final MenuService menuService;

    public Mono<ServerResponse> currentUserGetHandler(ServerRequest request) {
        return ok()
                .contentType(APPLICATION_JSON)
                .body(fromValue(getUsuario()));
    }

    public Mono<ServerResponse> login(ServerRequest request) {
        return request.bodyToMono(LoginRequest.class).flatMap(body -> 
                getMenuItem().flatMap(menu -> ok()
                        .contentType(APPLICATION_JSON)
                        .body(fromValue(LoginResponse.builder()
                                .token("fake-jwt-token")
                                .usuario(getUsuario())
                                .menu(menu)
                                .expiresIn(100000)
                                .build())
                        )
                ));
    }

    public Mono<ServerResponse> logout(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON).build();
    }

    public Mono<ServerResponse> loadMenuItem(ServerRequest request) {
        return getMenuItem()
                .flatMap(menu -> ok()
                        .contentType(APPLICATION_JSON)
                        .body(fromValue(menu)));
    }

    private Mono<List<MenuItem>> getMenuItem() {
        return menuService.getMenuForUser(1); // Assuming userId 1 for dummy auth
    }

    private Usuario getUsuario() {
        return Usuario.builder()
                .id("1")
                .login("user")
                .nome("user name")
                .email("emai@user.com")
                .ativo(true)
                .dataCadastro(LocalDateTime.now().atOffset(ZoneOffset.MAX))
                .ultimoAcesso(LocalDateTime.now().atOffset(ZoneOffset.MAX))
                .agenteSaudeId(null)
                .build();
    }
}
