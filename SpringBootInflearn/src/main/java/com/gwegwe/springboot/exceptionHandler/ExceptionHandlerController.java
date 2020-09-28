package com.gwegwe.springboot.exceptionHandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionHandlerController {
  // 기본은 BasicErrorController에 정의 되어 있다.
  // error 커스텀 페이지를 마들 수 도 있다.
  // ErrorViewResolver를 사용 가능

  @GetMapping("/exception-test")
  public String exceptionHandlerTest() {
    throw new SampleException();
  }

  // ExceptionHandler 어노테이션으로 특정 익셉션을 잡아 처리한다.
  @ExceptionHandler(SampleException.class)
  public @ResponseBody
  AppError sampleError(SampleException e) {
    AppError error = new AppError();
    error.setMessage("message");
    error.setReason("reason");

    return error;
  }
}
