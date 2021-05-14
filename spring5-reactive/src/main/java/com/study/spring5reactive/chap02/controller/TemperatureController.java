package com.study.spring5reactive.chap02.controller;

import com.study.spring5reactive.chap02.domain.Temperature;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class TemperatureController {

  private final Set<SseEmitter> clients = new CopyOnWriteArraySet<>();

  @GetMapping("/temperature-stream")
  public SseEmitter events(HttpServletRequest request) {
    SseEmitter emitter = new SseEmitter();
    clients.add(emitter);

    // remove emitter from clients on error or disconnect
    emitter.onTimeout(() -> clients.remove(emitter));
    emitter.onCompletion(() -> clients.remove(emitter));
    return emitter;
  }

  @Async
  @EventListener
  public void handleMessage(Temperature temperature) {
    List<SseEmitter> deadEmitters = new ArrayList<>();
    clients.forEach(emitter -> {
      try {
        emitter.send(temperature, MediaType.APPLICATION_JSON);
      } catch (Exception ignore) {
        deadEmitters.add(emitter);
      }
    });

    clients.removeAll(deadEmitters);
  }
}
