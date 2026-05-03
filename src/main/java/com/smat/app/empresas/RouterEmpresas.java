package com.smat.app.empresas;

import com.smat.app.empresas.model.RamosAtividade;
import com.smat.app.empresas.model.RepresentantesEmpresa;
import com.smat.app.empresas.model.TelefonesEmpregadores;
import com.smat.app.empresas.model.TiposEmpregadores;
import com.smat.app.empresas.repository.*;
import com.smat.app.empresas.service.EmpresasService;
import com.smat.app.fiscalizacoes.model.Empregadores;
import com.smat.common.repository.BasicDBOperations;
import com.smat.common.route.Router;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.List;

import static com.smat.common.repository.BasicDBOperations.commonHandler;
import static com.smat.common.route.Router.findByParams;
import static com.smat.common.route.Router.routeBuilder;

@Configuration(proxyBeanMethods = false)
@AllArgsConstructor
public class RouterEmpresas {

    private Router router;
    public static final String TAG = "Empresas";
    public static final String MODULO = "empresas/";

    @Bean
    public List<RouterFunction<ServerResponse>> empresasEndpoints(
            RamosAtividadeRepository        ramosAtividadeRepository,
            RepresentantesEmpresaRepository representantesEmpresaRepository,
            TelefonesEmpregadoresRepository telefonesEmpregadoresRepository,
            TiposEmpregadoresRepository     tiposEmpregadoresRepository,
            EmpregadoresRepository          empregadoresRepository
    ) {
        return router.beanRegister(TAG, MODULO,
                ramosAtividadeRepository,
                representantesEmpresaRepository,
                telefonesEmpregadoresRepository,
                tiposEmpregadoresRepository,
                empregadoresRepository
        );
    }

    @Bean
    public RouterFunction<ServerResponse> routeEmpregadoresExtended(EmpresasService empresasService) {
        return routeBuilder(
                List.of(
                        findByParams(
                                TAG,
                                MODULO ,
                                Empregadores.class,
                                request -> commonHandler(() -> empresasService.findAll(request.queryParam("razaoSocial").orElseThrow())),
                                org.springdoc.core.fn.builders.parameter.Builder.parameterBuilder()
                                        .name("razaoSocial").in(ParameterIn.QUERY).required(true)
                        )
                )
        );
    }
}
