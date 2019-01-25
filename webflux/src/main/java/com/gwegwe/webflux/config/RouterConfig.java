package com.gwegwe.webflux.config;

import com.gwegwe.webflux.controller.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * The router listens for traffic on the /greeting path and returns the value provided by our reactive handler class.
 */

@Configuration
public class RouterConfig {

  @Bean
  public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
    return RouterFunctions
        .route(RequestPredicates.GET("/greeting").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), greetingHandler::greeting);
  }
}
