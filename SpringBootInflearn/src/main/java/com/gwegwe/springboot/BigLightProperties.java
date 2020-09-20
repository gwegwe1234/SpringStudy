package com.gwegwe.springboot;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

// 프로퍼티 파일 (@Value 같은거 쓰지말고 이거로 쓰자)

@Component
@ConfigurationProperties("biglight")
@Valid
public class BigLightProperties {

  @NotEmpty // JSR-303 javax validation
  private String name;
  private int age;
  private String fullName;

  @DurationUnit(ChronoUnit.SECONDS)
  private Duration duration = Duration.ofSeconds(30);

  public Duration getDuration() {
    return duration;
  }

  public void setDuration(Duration duration) {
    this.duration = duration;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
}
