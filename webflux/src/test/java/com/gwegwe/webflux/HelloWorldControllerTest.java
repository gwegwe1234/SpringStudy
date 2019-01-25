package com.gwegwe.webflux;

import static org.assertj.core.api.Assertions.assertThat;

import com.gwegwe.webflux.controller.HelloWorldHandler;
import com.gwegwe.webflux.vo.HelloWorld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest
@Import(value= HelloWorldHandler.class)
public class HelloWorldControllerTest {

  @Autowired
  private WebTestClient webClient;

  @Test
  public void test_HelloWorldRouter() {
    //WebClient로 "hello"라는 URL을 호출
    HelloWorld responseBody = webClient.get().uri("/helloWebFlux").exchange()
        .expectStatus().isOk() // 응답이 200인지 확인
        .expectBody(HelloWorld.class) // 리턴하는 객체가 HelloWorld클래스인지 확인
        .returnResult().getResponseBody();

    //response된 객체에 원하는 결과값이 들어있는지 assert함.
    assertThat(responseBody.getId()).isEqualTo(1);
    assertThat(responseBody.getTitle()).isEqualTo("hello");
    assertThat(responseBody.getMessage()).isEqualTo("Hi Webflux!");

  }

  @Test
  public void test_FailExecutePostMethod() {
    //Post는 지원하지 않는 method
    webClient.post().uri("/helloWebFlux").exchange()
        .expectStatus().isEqualTo(HttpStatus.METHOD_NOT_ALLOWED);
  }
}
