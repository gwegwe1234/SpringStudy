package com.study.spring5reactive.chap02.service;

import com.study.spring5reactive.chap02.domain.Temperature;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TemperatureSensor {
  private final ApplicationEventPublisher publisher;
  private final Random rnd = new Random();
  private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

  public TemperatureSensor(ApplicationEventPublisher publisher) {
    this.publisher = publisher;
  }

  @PostConstruct
  public void startProcessing() {
    this.executor.schedule(this::probe, 1, TimeUnit.SECONDS);
  }

  private void probe() {
    double temperature = 16 + rnd.nextGaussian() * 10;
    publisher.publishEvent(new Temperature(temperature));
    // random한 지연시간(0~5초)를 두고 다음 읽기 스케줄 예약
    executor.schedule(this::probe, rnd.nextInt(5000),TimeUnit.MILLISECONDS);
  }
}
