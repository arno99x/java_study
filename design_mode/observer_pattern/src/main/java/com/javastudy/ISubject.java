package com.javastudy;

public interface ISubject {
  void registerObserver(IObserver observer);
  void removeObserver(IObserver observer);
  void notifyObservers();
}
