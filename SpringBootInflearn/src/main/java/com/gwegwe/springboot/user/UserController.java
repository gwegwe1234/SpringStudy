package com.gwegwe.springboot.user;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

//  Spring boot에선 #WebMvcAutoConfiguration 을 자동으로 설정해 줘서 특별한 설정 없이 WebMvc 사용이 가능하다.
  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }

  @PostMapping("/create")
  public @ResponseBody User create(@RequestBody User user) {
    // 이렇게 @ResponseBody, @RequestBody 를 붙이면 스프링 부트에서 HttpMessageConverter로 컨버팅 해준다.
    // 예를들어 User로 뱉어주면, Json converter에서 처리한다.
    // 컨트롤러가 @RestController가 아니면, 무조건 @ResponseBody를 붙여야 컨버터를 찾아가준다.
    // 안붙이면 뷰리졸버를 찾아간다.

    return null;
  }

  @PostMapping("/users/create")
  public User createUsers(@RequestBody  User user) {
    return user;
  }


}
