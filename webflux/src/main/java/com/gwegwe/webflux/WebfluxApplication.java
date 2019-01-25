package com.gwegwe.webflux;

import com.gwegwe.webflux.controller.GreetingWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 참고 사이트 : https://spring.io/guides/gs/reactive-rest-service/
 * you use Reactive Spring’s support for embedding the Netty server as the HTTP runtime,
 * instead of deploying to an external instance. (war 같은거)
 */
@SpringBootApplication
public class WebfluxApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebfluxApplication.class, args);

    GreetingWebClient gwc = new GreetingWebClient();
    System.out.println(gwc.getResult());
  }
}

