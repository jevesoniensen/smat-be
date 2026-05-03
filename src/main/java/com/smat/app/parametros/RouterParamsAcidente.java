package com.smat.app.parametros;

import com.smat.app.parametros.model.acidente.*;
import com.smat.app.parametros.repository.acidente.*;
import com.smat.common.repository.BasicDBOperations;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.List;

import static com.smat.common.repository.BasicDBOperations.commonHandler;
import static com.smat.common.route.Router.*;

@Configuration(proxyBeanMethods = false)
public class RouterParamsAcidente {

    public static final String TAG = "Parametros";
    public static final String MODULO = "params/";

    @Bean
    public RouterFunction<ServerResponse> routeAgentesCausadores(AgentesCausadoresRepository repository) {
        return routeCRUD(TAG, MODULO, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeAgentesCausadoresExtended(AgentesCausadoresRepository repository) {
        return routeBuilder(
                List.of(
                        findByParams(
                                TAG,
                                MODULO,
                                AgentesCausadores.class,
                                request -> commonHandler(() -> repository.findAllByPaiId(request.queryParam("paiId").map(Integer::parseInt).orElseThrow())),
                                org.springdoc.core.fn.builders.parameter.Builder.parameterBuilder()
                                        .name("paiId").in(ParameterIn.QUERY).required(true)
                        )
                )
        );
    }

    @Bean
    public RouterFunction<ServerResponse> routeEmitentes(EmitentesRepository repository) {
        return routeCRUD(TAG, MODULO, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeFontes(FontesRepository repository) {
        return routeCRUD(TAG, MODULO, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeLocaisAtendimento(LocaisAtendimentoRepository repository) {
        return routeCRUD(TAG, MODULO, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeTiposAcidente(TiposAcidenteRepository repository) {
        return routeCRUD(TAG, MODULO, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeTiposLocalAcidente(TiposLocalAcidenteRepository repository) {
        return routeCRUD(TAG, MODULO, repository);
    }
}
