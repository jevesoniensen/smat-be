package com.smat.common.route;

import com.smat.common.repository.BasicDBOperations;
import com.smat.common.repository.JpaRepositoryExtended;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.fn.builders.operation.Builder;
import org.springdoc.webflux.core.fn.SpringdocRouteBuilder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.springdoc.core.fn.builders.apiresponse.Builder.responseBuilder;
import static org.springdoc.core.fn.builders.parameter.Builder.parameterBuilder;
import static org.springdoc.core.fn.builders.requestbody.Builder.requestBodyBuilder;
import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
@AllArgsConstructor
public class Router {

    private static Logger logger = LoggerFactory.getLogger(Router.class);

    private ConfigurableListableBeanFactory beanFactory;

    public List<RouterFunction<ServerResponse>> beanRegister(String tag, String modulo, JpaRepositoryExtended<?, Integer>... repoList) {
        return Stream.of(repoList).map(repository -> {
            var basicDBOperations = new BasicDBOperations<>(repository);
            String beanName = "beanCrud%s".formatted(repository.getClazz().getSimpleName());
            RouterFunction<ServerResponse> crud = routeCRUD(tag, modulo, basicDBOperations.repository());
            this.beanFactory.initializeBean(crud, beanName);
            this.beanFactory.autowireBean(crud);
            this.beanFactory.registerSingleton(beanName, crud);
            return crud;
        }).toList();
    }

    public static <T> RouterFunction<ServerResponse> routeBuilder(List<Consumer<SpringdocRouteBuilder>> endpoints) {
        return aggregator(route(),
                endpoints
        );
    }

    public static <T> RouterFunction<ServerResponse> routeView(String tag, JpaRepositoryExtended<T, Integer> repository) {
        return routeView(tag, "", repository);
    }

    public static <T> RouterFunction<ServerResponse> routeView(String tag, String module, JpaRepositoryExtended<T, Integer> repository) {
        var basicDBOperations = new BasicDBOperations<>(repository);
        return aggregator(route(),
                List.of(
                        findById(tag, module, repository.getClazz(), basicDBOperations::findById),
                        findAll(tag, module, basicDBOperations.repository())
                )
        );
    }

    public static <T> RouterFunction<ServerResponse> routeCRUD(String tag, JpaRepositoryExtended<T, Integer> repository) {
        return routeCRUD(tag, "", repository);
    }

    public static <T> RouterFunction<ServerResponse> routeCRUD(String tag, String module, JpaRepositoryExtended<T, Integer> repository) {
        var basicDBOperations = new BasicDBOperations<>(repository);
        return aggregator(route(),
                List.of(
                        findAll(tag, module, repository),
                        findById(tag, module, repository.getClazz(), basicDBOperations::findById),
                        create(tag, module, repository),
                        update(basicDBOperations, tag, module, repository),
                        delete(tag, module, repository),
                        route -> route.onError(Exception.class, Router::handleException)
                )
        );
    }

    private static @NonNull Mono<ServerResponse> handleException(Exception e, ServerRequest req) {
        logger.error(e.getMessage(), e);
        return ServerResponse.status(500).bodyValue(e.getMessage());
    }

    private static <T> @NonNull String getEndPointName(Class<T> clazz) {
        return clazz.getSimpleName().toLowerCase();
    }

    public static <T> Consumer<SpringdocRouteBuilder> findAll(String tag, String module, JpaRepositoryExtended<T, Integer> repository) {
        var basicDBOperations = new BasicDBOperations<>(repository);
        return route -> route.GET(
                "/api/%s%s".formatted(module, getEndPointName(repository.getClazz())),
                accept(APPLICATION_JSON), basicDBOperations::findAll,
                ops -> getResponse(ops, repository.getClazz(), tag, "findAll", "200", "Find all")
        );
    }

    public static <T> Consumer<SpringdocRouteBuilder> findByParams(String tag, String module,
                                                                   Class<T> clazz, HandlerFunction<ServerResponse> handler,
                                                                   org.springdoc.core.fn.builders.parameter.Builder parametersBuilder) {
        return route -> route.GET("/api/%ssearch/%s".formatted(module, getEndPointName(clazz)), accept(APPLICATION_JSON), handler,
                ops -> ops.operationId("findByParams")
                        .tag(tag)
                        .parameter(parametersBuilder)
                        .response(responseBuilder().responseCode("200")
                                .description("Existing entity")
                                .implementation(clazz)));
    }

    public static <T> Consumer<SpringdocRouteBuilder> findById(String tag, String module, Class<T> clazz, HandlerFunction<ServerResponse> handler) {
        return route -> route.GET("/api/%s%s/{id}".formatted(module, getEndPointName(clazz)), accept(APPLICATION_JSON), handler,
                ops -> ops.operationId("findById")
                        .tag(tag)
                        .parameter(parameterBuilder().name("id").in(ParameterIn.PATH).required(true).schema(org.springdoc.core.fn.builders.schema.Builder.schemaBuilder().type("integer").pattern("[0-9]+")))
                        .response(responseBuilder().responseCode("200")
                                .description("Existing entity")
                                .implementation(clazz)));
    }

    public static <T> Consumer<SpringdocRouteBuilder> delete(String tag, String module, JpaRepositoryExtended<T, Integer> repository) {
        var basicDBOperations = new BasicDBOperations<>(repository);
        return route -> route.DELETE("/api/%s%s/{id}".formatted(module, getEndPointName(repository.getClazz())), accept(APPLICATION_JSON), basicDBOperations::delete,
                ops -> ops.operationId("delete")
                        .tag(tag)
                        .parameter(parameterBuilder().name("id").in(ParameterIn.PATH).required(true).schema(org.springdoc.core.fn.builders.schema.Builder.schemaBuilder().type("integer").pattern("[0-9]+")))
                        .response(responseBuilder().responseCode("200").description("Deleted")));
    }

    public static <T> Consumer<SpringdocRouteBuilder> create(String tag, String module, JpaRepositoryExtended<T, Integer> repository) {
        var basicDBOperations = new BasicDBOperations<>(repository);
        return route -> route.POST(
                "/api/%s%s".formatted(module, getEndPointName(repository.getClazz())),
                accept(APPLICATION_JSON), basicDBOperations::create,
                ops -> getChangeOperation(ops, repository.getClazz(), repository.getClazz(),tag, "create", "200")
        );
    }

    public static <T> Consumer<SpringdocRouteBuilder> update(BasicDBOperations<T> v, String tag, String module, JpaRepositoryExtended<T, Integer> repository) {
        var basicDBOperations = new BasicDBOperations<>(repository);
        return route -> route.PUT(
                "/api/%s%s/{id}".formatted(module, getEndPointName(repository.getClazz())),
                accept(APPLICATION_JSON), basicDBOperations::update,
                ops -> getChangeOperation(ops, repository.getClazz(), repository.getClazz(),tag, "update", "204")

        );
    }

    private static RouterFunction<ServerResponse> aggregator(SpringdocRouteBuilder route, List<Consumer<SpringdocRouteBuilder>> methodList) {
        for (Consumer<SpringdocRouteBuilder> method : methodList) {
            method.accept(route);
        }
        return route.build();
    }

    public static <T,R> void getChangeOperation(Builder ops, Class<T> requestClass, Class<R> responseClass, String tag, String create, String responseCode) {
        ops.operationId(create)
                .tag(tag)
                .parameter(parameterBuilder().name("id").in(ParameterIn.PATH).required(true).schema(org.springdoc.core.fn.builders.schema.Builder.schemaBuilder().type("integer").pattern("[0-9]+")))
                .requestBody(requestBodyBuilder().implementation(requestClass))
                .response(responseBuilder().responseCode(responseCode).implementation(responseClass));
    }

    public static <T> void getResponse(Builder ops,
                                        Class<T> clazz,
                                        String tag, String operationId,
                                        String responseCode,
                                        String description) {
        ops.operationId(operationId).tag(tag)
                .response(responseBuilder()
                        .responseCode(responseCode)
                        .description(description)
                        .implementationArray(clazz)
                );
    }
}
