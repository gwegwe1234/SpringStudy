package com.study.spring5reactive.chap02;

public class ConcreteObserverB implements Observer<String> {
  @Override
  public void observe(String event) {
    System.out.println("Observer B : " + event);
  }
}
