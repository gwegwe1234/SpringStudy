package com.in28minutes.spring.basics.springin5steps.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // => 스코프 설정하는 어노테이션
public class BinarySearchImpl {

  private Logger LOG = LoggerFactory.getLogger(this.getClass());

  /**
   * BinarySearchImpl은 SortAlgorithm 을 depends on 한다.
   * SortAlgorithm은 BinarySearchImpl의 dependency다.
   * autowiring 의 bean 선택은 3가지 (우선순위순)
   * 1. @Qualifier
   * 2. @Primary
   * 3. 변수명을 dependency 빈 이름으로 (ex private SortAlgorithm bubbleSortAlgorithm)
   */
  @Autowired
  @Qualifier("quick")
  private SortAlgorithm sortAlgorithm;
  //private SortAlgorithm bubbleSortAlgorithm; => Primary 없어도 이름을 bubbleSort로 지으면, bubbleSort로 autowired 한다.

  /**
   * Setter Injection
   * 없으면 스프링에서 알아서 SetterInjection 진
   */
  public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
    this.sortAlgorithm = sortAlgorithm;
  }

  /**
   * Constructor 만들어서 동적 반영
   * interface 만들어서 그걸 constructor 인자로 받음
   */
//  public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
//    super();
//    this.sortAlgorithm = sortAlgorithm;
//  }



  public int binarySearch(int[] numbers, int numberToSearchFor) {

    //BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm(); -> tight coupled

    int sortedNumbers[] = sortAlgorithm.sort(numbers);
    System.out.println(sortAlgorithm);
    // Search the array
    return 3;
  }

  @PostConstruct
  public void postConstruct() {
    LOG.info("Post Contruct");
  }

  @PreDestroy
  public void preDestroy() {
    LOG.info("Pre Destroy");
  }
}
