package com.smat.common.repository;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public record BasicDBOperations<T>(JpaRepositoryExtended<T, Integer> repository) {

     public static <R> Mono<ServerResponse> commonHandler(Supplier<R> handler) {
          return ok()
                  .contentType(APPLICATION_JSON)
                  .body(fromValue(handler.get()));
     }

     public Mono<ServerResponse> findAll(ServerRequest request) {
          return commonHandler(repository::findAll);
     }

     public Mono<ServerResponse> findById(ServerRequest request) {
          return commonHandler(() -> repository.findById(Integer.valueOf(request.pathVariable("id"))));
     }

     public Mono<ServerResponse> create(ServerRequest request) {
          return request.bodyToMono(repository.getClazz()).flatMap(body -> {
               var entity = repository.save(body);
               return ok()
                       .contentType(APPLICATION_JSON)
                       .body(fromValue(entity));
          });
     }

     public Mono<ServerResponse> update(ServerRequest request) {
          return request.bodyToMono(repository.getClazz()).flatMap(body -> {
               var entity = repository.findById(Integer.valueOf(request.pathVariable("id")))
                       .orElseThrow(() -> new RuntimeException("findById -> Not found"));
               T apply = repository.getUpdater().update(body, entity);
               repository.save(apply);
               return ok()
                       .contentType(APPLICATION_JSON)
                       .body(fromValue(body));
          });
     }

     public Mono<ServerResponse> delete(ServerRequest request) {
          repository.deleteById(Integer.valueOf(request.pathVariable("id")));
          return ok().contentType(APPLICATION_JSON).build();
     }
}
