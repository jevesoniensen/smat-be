package com.smat.app.fiscalizacoes.controller;

import com.smat.app.fiscalizacoes.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.smat.common.route.Router.routeCRUD;

@Configuration(proxyBeanMethods = false)
public class RouterFiscalizacoes {

    public static final String TAG = "Fiscalizacoes";

    @Bean
    public RouterFunction<ServerResponse> routeFiscalizacoes(FiscalizacoesRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeItensFiscalizacao(ItensFiscalizacaoRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeRoteiros(RoteirosRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routePontosFiscalizacoes(PontosFiscalizacoesRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routePontosFiscalizacaoRamosAtividade(PontosFiscalizacaoRamosAtividadeRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routePontosFiscalizacaoItensFiscal(PontosFiscalizacaoItensFiscalRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeTramitesFiscalizacao(TramitesFiscalizacaoRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeMedidasCorretivasFiscalizacao(MedidasCorretivasFiscalizacaoRepository repository) {
        return routeCRUD(TAG, repository);
    }
}

