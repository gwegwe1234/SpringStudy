package com.gwegwe.springboot.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

  // 이건 레스트 컨트롤러가 아닌 컨트롤러이므로, 리턴 타입이 스트링이어도 실제 스트링이 아닌 뷰의 이름이다.
  @GetMapping("/hello-thymeleaf")
  public String hello(Model model) {
    model.addAttribute("name", "biglight");
    return "helloo";
  }
}
