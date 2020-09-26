package com.gwegwe.springboot.sample;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
// 스프링 부트 테스트는 기본으로 MOCK으로 뜬다. SpringBootTest는 통합 테스트로, Application의 스프링 부트 가 처음부터 뜨면서 모든 스프링 빈을 다 설정한다.
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
// AUtoConfigureMockMvc 어노테이션 붙여주면 MockMvc 사용 가능
@AutoConfigureMockMvc
public class SampleControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  TestRestTemplate testRestTemplate;

  // 웹 플럭스 용, 비동기 RestTemplate 같은거
//  @Autowired
//  WebTestClient webTestClient;

  // 목으로 사용하기 위한 기존 서비스를 새롭게 빈설정을 해준다 (온리 테스트용). 빈을 테스트내에선 교채해준다.
  @MockBean
  SampleService mockSampleService;

  @Test
  public void hello() throws Exception {
    mockMvc.perform(get("/hello"))
        .andExpect(status().isOk())
        .andExpect(content().string("helloted"))
        .andDo(print());
  }

  @Test
  public void mockBeanHello() throws Exception {
    when(mockSampleService.getName()).thenReturn(" biglight");

    mockMvc.perform(get("/hello"))
        .andExpect(status().isOk())
        .andExpect(content().string("hello biglight"))
        .andDo(print());
  }

//  @Test
//  public void webTestClientHello() throws Exception {
//    webTestClient.get().uri("/hello").exchange()
//        .expectStatus().isOk()
//        .expectBody(String.class).isEqualTo("helloted");
//  }
}