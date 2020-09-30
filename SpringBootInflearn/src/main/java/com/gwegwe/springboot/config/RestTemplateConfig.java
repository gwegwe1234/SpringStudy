package com.gwegwe.springboot.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.reactive.function.client.WebClient.Builder;

public class RestTemplateConfig {

  @Bean
  public WebClientCustomizer webClientCustomizer() {
//    final WebClientCustomizer webClientCustomizer = new WebClientCustomizer() {
//      @Override
//      public void customize(Builder webClientBuilder) {
//        webClientBuilder.baseUrl("http://localhost:8080/custom");
//      }
//    };
    return webClientBuilder -> webClientBuilder.baseUrl("http://local~~");
  }

  @Bean
  public RestTemplateCustomizer restTemplateCustomizer() {
    return restTemplateBuilder -> restTemplateBuilder.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
  }
}
