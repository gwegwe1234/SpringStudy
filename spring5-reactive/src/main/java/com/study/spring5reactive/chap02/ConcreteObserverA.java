package com.study.spring5reactive.chap02;

public class ConcreteObserverA implements Observer<String> {
  @Override
  public void observe(String event) {
    System.out.println("Observer A : " + event);
  }
}
