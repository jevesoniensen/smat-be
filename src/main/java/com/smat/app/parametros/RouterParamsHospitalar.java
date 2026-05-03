package com.smat.app.parametros;

import com.smat.app.parametros.model.hospitalar.LocaisLesao;
import com.smat.app.parametros.repository.hospitalar.DiagnosticosRepository;
import com.smat.app.parametros.repository.hospitalar.LocaisLesaoRepository;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.List;

import static com.smat.common.repository.BasicDBOperations.commonHandler;
import static com.smat.common.route.Router.*;

@Configuration(proxyBeanMethods = false)
public class RouterParamsHospitalar {

    public static final String TAG = "Parametros";
    public static final String MODULO = "params/";

    @Bean
    public RouterFunction<ServerResponse> routeDiagnosticos(DiagnosticosRepository repository) {
        return routeCRUD(TAG, MODULO, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeLocaisLesao(LocaisLesaoRepository repository) {
        return routeCRUD(TAG, MODULO, repository);
    }

    @Bean
    public RouterFunction<ServerResponse> routeLocaisLesaoExtended(LocaisLesaoRepository repository) {
        return routeBuilder(
                List.of(
                        findByParams(
                                TAG,
                                MODULO,
                                LocaisLesao.class,
                                request -> commonHandler(() -> repository.findAllByPaiId(request.queryParam("paiId").map(Integer::parseInt).orElseThrow())),
                                org.springdoc.core.fn.builders.parameter.Builder.parameterBuilder()
                                        .name("paiId").in(ParameterIn.QUERY).required(true)
                        )
                )
        );
    }
}
