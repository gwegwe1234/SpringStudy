package com.gwegwe.spring.security.basicauthentication.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @GetMapping("/")
  public String greeting() {
    return "Hello, World!";
  }
}

