package com.gwegwe.webflux.controller;

import com.gwegwe.webflux.vo.HelloWorld;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 *  HelloWorldController의 RestController와 같은 역할을 하게 동작한다.
 *  그냥 보기에 Controller 방식보다 코드도 훨씬 길고 가독성도 떨어지는거 같지만
 *  좀 더 Spring이 functional한 프로그래밍이 가능해졌다로 정리할 수 있다. (config 설정 포함됨)
 */
@Component
public class HelloWorldHandler {
  public Mono<ServerResponse> hellowWorld(ServerRequest request) {
    Mono<HelloWorld> helloWorldMono = Mono.just(new HelloWorld(1, "hello", "Hi Webflux!"));
    return ServerResponse.ok().body(helloWorldMono, HelloWorld.class);
  }
}
