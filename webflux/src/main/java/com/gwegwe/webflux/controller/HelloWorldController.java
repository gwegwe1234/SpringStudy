package com.gwegwe.webflux.controller;

import com.gwegwe.webflux.vo.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 기존 Spring 방식과 큰 차이는 없으며 대신 Flux와 Mono로 return 할 수 있게 됨.
 * 단일건은 Mono, 여러건을 리턴할때는 Flux를 사용하면 됩니다.
 */
@RestController
public class HelloWorldController {

  @GetMapping("/hello")
  public Mono<HelloWorld> hello() {
    HelloWorld helloWorld = new HelloWorld();
    helloWorld.setTitle("hello");
    helloWorld.setMessage("hi yo");
    return Mono.just(helloWorld);
  }
}
