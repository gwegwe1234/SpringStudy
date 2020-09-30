package com.gwegwe.springboot.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SercurityController {

  // 시큐리티 자동설정 : SecurityAutoConfiguration
  @GetMapping("/security-hello")
  public String securityHello() {
    return "securityHello";
  }

  @GetMapping("/my")
  public String my() {
    return "my";
  }

}
