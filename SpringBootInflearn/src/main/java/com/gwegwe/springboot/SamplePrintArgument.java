package com.gwegwe.springboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class SamplePrintArgument {

  public SamplePrintArgument(ApplicationArguments arguments) {
    // editConfiguration 에서 -Dfoo --bar 추가
    System.out.println("foo : " + arguments.containsOption("foo"));
    System.out.println("bar : " + arguments.containsOption("bar"));
    /*
    foo : false
    bar : true

    -- 로 들어오는거만 캐치한다. JVM 옵션은 스프링 아규먼트로 취급 x

    ApplicationRunner 를 구현하면 오버라이딩해서 깔끔하게 구현 가능 (HolomanRunner)
     */
  }
}
