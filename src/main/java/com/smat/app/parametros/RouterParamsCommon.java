package com.smat.app.parametros;

import com.smat.app.parametros.model.common.*;
import com.smat.app.parametros.repository.common.*;
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
public class RouterParamsCommon {

    public static final String TAG = "Parametros";
    public static final String MODULO = "params/";

    @Bean
    public RouterFunction<ServerResponse> routeAreas(AreasRepository repository) {
        return routeCRUD(TAG, MODULO, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeEstados(EstadosRepository repository) {
        return routeCRUD(TAG, MODULO, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeEstadosCivis(EstadosCivisRepository repository) {
        return routeCRUD(TAG, MODULO, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeMunicipios(MunicipiosRepository repository) {
        return routeCRUD(TAG, MODULO, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeMunicipiosExtended(MunicipiosRepository repository) {
        return routeBuilder(
                List.of(
                        findByParams(
                                TAG,
                                MODULO,
                                Municipios.class,
                                request -> commonHandler(() -> repository.findBySigla(request.queryParam("sigla").orElseThrow())),
                                org.springdoc.core.fn.builders.parameter.Builder.parameterBuilder()
                                        .name("sigla").in(ParameterIn.QUERY).required(true)
                        )
                )
        );
    }

    @Bean
    public RouterFunction<ServerResponse> routeOcupacoes(OcupacoesRepository repository) {
        return routeCRUD(TAG, MODULO, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeVinculosEmpregaticios(VinculosEmpregasticosRepository repository) {
        return routeCRUD(TAG, MODULO, repository);
    }
}
