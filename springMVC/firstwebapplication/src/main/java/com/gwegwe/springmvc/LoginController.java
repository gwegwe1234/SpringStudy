package com.gwegwe.springmvc;

import com.gwegwe.jee.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * tell spring this is controller 컨트롤러 달아줘야 디스패쳐에서 이 class를 뒤져본다. 디스패쳐는 web.xml에서 설정
 */
@Controller
public class LoginController {

  @Autowired
  LoginService service;

  /**
   * Request Mapping 으로 url 설정
   *
   * spring-mvc DispatcherServlet /login -> Login Controller에서 handler 된다. /spring-mvc/login 으로
   * 들어오면, Hello World가 return 되고, @responseBody가 없으면 스프링(DispatcherServlet)은 Hellow World가 뭔지 모른다.
   * login.jsp 로 redirect 하기 위해선, viewResolver를 등록해줘야한다. viewResolver는 web.xml에 등록 or webconfig에 자바
   * 빈으로 등록. InternalResourceViewResolver class
   */
  @RequestMapping(value = "/login", method = RequestMethod.GET)
//  @ResponseBody
  public String showLoginPage() {
    return "login";
  }

  /**
   * post로 값을 전달받으려면, @RequestParam사용
   * jsp로 name을 전달하려면?
   * -> model사용한다.
   * model은 controller랑 view사이에서 값전달
   */

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model) {
    if(!service.validateUser(name,password)) {
      model.put("errorMessage","Invalid Credntials");
      return "login";
    }

    model.put("name", name);
    model.put("password", password);
    return "welcome";

  }
}
