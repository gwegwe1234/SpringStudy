package com.gwegwe.springboot.cors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsController {

  @CrossOrigin(origins = "http://localhost:18080") // 이런식으로 크로스 오리진 어노테이션으로 cors적용 가능하다
  @GetMapping("/helloCors")
  public String helloCors() {
    return "cors";
  }
}
