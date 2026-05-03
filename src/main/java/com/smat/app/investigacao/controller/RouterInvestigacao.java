package com.smat.app.investigacao.controller;

import com.smat.app.investigacao.repository.DadosInvestigacaoRepository;
import com.smat.app.investigacao.repository.InvestigacoesRepository;
import com.smat.app.investigacao.repository.MedidasCorretivasInvestigacaoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.smat.common.route.Router.routeCRUD;

@Configuration(proxyBeanMethods = false)
public class RouterInvestigacao {

    public static final String TAG = "Investigacao";

    @Bean
    public RouterFunction<ServerResponse> routeInvestigacoes(InvestigacoesRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeMedidasCorretivasInvestigacao(MedidasCorretivasInvestigacaoRepository repository) {
        return routeCRUD(TAG, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeDadosInvestigacao(DadosInvestigacaoRepository repository) {
        return routeCRUD(TAG, repository);
    }
}

