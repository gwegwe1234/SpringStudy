package com.gwegwe.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc 이거 넣으면 죄다 다시 설정해줘야 되니까 특별한 경우 아니면 그냥 WebMvcConfigurer 정도만 구현해서 새롭게 재정의 하고 싶은걸 재정의하자.
public class WebConfig implements WebMvcConfigurer {

}
