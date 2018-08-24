package com.javastudy.inner_observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditions2 implements Observer {
  private float mTemperatrue;
  private float mPressure;
  private float mHumidity;
  
  @Override
  public void update(Observable o, Object arg) {
    System.out.println(o);
    WeatherDataSt2.Data data = (WeatherDataSt2.Data)arg;
    this.mTemperatrue = data.mTemperatrue;
    this.mPressure = data.mPressure;
    this.mHumidity = data.mHumidity;
    display();
  }
  
  public void display() {
    System.out.println("Today mTemperatrue:" + this.mTemperatrue);
    System.out.println("Today mPressure:" + this.mPressure);
    System.out.println("Today mHumidity:" + this.mHumidity);
  }
}
