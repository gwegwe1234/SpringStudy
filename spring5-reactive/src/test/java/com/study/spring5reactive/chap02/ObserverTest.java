package com.study.spring5reactive.chap02;

import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ObserverTest {

  @Test
  public void observersHandleEventsFromSubject() {
    //given
    Subject<String> subject = new ConcreteSubject();
    Observer<String> observerA = Mockito.spy(new ConcreteObserverA());
    Observer<String> observerB = Mockito.spy(new ConcreteObserverB());

    //when
    subject.notifyObservers("No listeners");

    subject.registerObserver(observerA);
    subject.notifyObservers("Message for A");

    subject.registerObserver(observerB);
    subject.notifyObservers("Message for A and B");

    subject.unregisterObserver(observerA);
    subject.notifyObservers("Message for B");

    subject.unregisterObserver(observerB);
    subject.notifyObservers("No listeners");

    //then
    Mockito.verify(observerA, times(1)).observe("Message for A");
    Mockito.verify(observerA, times(1)).observe("Message for A and B");
    Mockito.verifyNoMoreInteractions(observerA);

    Mockito.verify(observerB, times(1)).observe("Message for B");
    Mockito.verify(observerB, times(1)).observe("Message for A and B");
    Mockito.verifyNoMoreInteractions(observerB);
  }

  @Test
  public void subjectLeveragesLamdas() {
    //given
    Subject<String> subject = new ConcreteSubject();

    subject.registerObserver(e -> System.out.println("A : " + e));
    subject.registerObserver(e -> System.out.println("B : " + e));
    subject.notifyObservers("Message for A and B");
  }
}
