package com.gwegwe.webflux.config;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

import com.gwegwe.webflux.controller.HelloWorldHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {
  @Bean
  public RouterFunction<ServerResponse> routes(HelloWorldHandler handler) {
    return RouterFunctions.route(GET("/helloWebFlux"), handler::hellowWorld);
  }
}
