package com.gwegwe.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@TestPropertySource(locations = "classpath:/test.properties")
    // 이런식으로 다른 프로퍼티파일을 읽도록 설정할 수 있다.
class ApplicationTests {

  @Autowired
  Environment environment;

  @Autowired
  BigLightProperties bigLightProperties;

  @Test
  void contextLoads() {
    System.out.println(bigLightProperties.getName());
    System.out.println(bigLightProperties.getAge());
    System.out.println(bigLightProperties.getFullName());
    System.out.println(bigLightProperties.getDuration());

    /*
    gwegwe
    100
    gwangtae
    PT40S
     */

    assertThat(environment.getProperty("biglight.name")).isEqualTo("gwegwe");
  }

}
