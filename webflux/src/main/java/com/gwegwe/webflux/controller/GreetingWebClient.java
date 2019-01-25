package com.gwegwe.webflux.controller;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * non-blocking 을 위해 WebClinet 제공
 * RESTful service를 사용하기 위해 WebClient를 사용
 *
 * WebClient can be used to communicate with non-reactive, blocking services, too.
 */

public class GreetingWebClient {
  private WebClient client = WebClient.create("http://localhost:8080");

  private Mono<ClientResponse> result =
      client.get()
      .uri("/greeting")
      .accept(MediaType.TEXT_PLAIN)
      .exchange();

  public String getResult() {
    return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
  }
}
