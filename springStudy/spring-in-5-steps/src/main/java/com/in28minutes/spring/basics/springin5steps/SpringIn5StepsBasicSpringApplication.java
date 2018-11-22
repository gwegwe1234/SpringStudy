package com.in28minutes.spring.basics.springin5steps;

import com.in28minutes.spring.basics.springin5steps.basic.BinarySearchImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.spring.basics.springin5steps")
public class SpringIn5StepsBasicSpringApplication {
  public static void main(String[] args) {

    try(AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(SpringIn5StepsBasicSpringApplication.class)) { // => java7에서 나온 걍 자동으로 파이널리처럼 닫는거

      BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
      BinarySearchImpl binarySearch2 = applicationContext.getBean(BinarySearchImpl.class);
      System.out.println(binarySearch);
      System.out.println(binarySearch2);

      int result = binarySearch.binarySearch(new int[]{12, 6}, 3);
    }

    // Spring은 닫아줘야된대...
//    applicationContext.close();
  }
}
