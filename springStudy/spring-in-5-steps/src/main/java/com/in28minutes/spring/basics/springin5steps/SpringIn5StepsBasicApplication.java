package com.in28minutes.spring.basics.springin5steps;

import com.in28minutes.spring.basics.springin5steps.basic.BinarySearchImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIn5StepsBasicApplication {

  /**
   * What are the beans?
   * What are the dependency of a bean? (@Component 를 사용하는 빈들)
   * Where to search for beans? -> Component Scan (디폴트는 같은 패키지)
   */

  public static void main(String[] args) {

    // BinarySearchImpl 이 QuickSortAlgorithm을 wiring 한다고 표현한다.
    //BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());


    //com.in28minutes.spring.basics.springin5steps.basic.BubbleSortAlgorithm@69ece8a6
    //com.in28minutes.spring.basics.springin5steps.basic.QuickSortAlgorithm@3f8f9dd6

    //ApplicationContext => getBean
    // Application Context로 @Component로 설정된 빈을 긁어온다.
    ApplicationContext applicationContext =
        SpringApplication.run(SpringIn5StepsBasicApplication.class, args);

    BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
    BinarySearchImpl binarySearch2 = applicationContext.getBean(BinarySearchImpl.class);
    System.out.println(binarySearch);
    System.out.println(binarySearch2);

    int result = binarySearch.binarySearch(new int[] {12,6},3);
  }
}
