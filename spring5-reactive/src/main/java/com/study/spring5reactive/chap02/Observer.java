package com.study.spring5reactive.chap02;

public interface Observer<T> {
  void observe(T event);
}
