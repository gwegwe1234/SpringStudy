package com.study.spring5reactive.chap02;

public interface Subject<T> {
  void registerObserver(Observer<T> observer);
  void unregisterObserver(Observer<T> observer);
  void notifyObservers(T event);
}
