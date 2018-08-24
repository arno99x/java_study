package com.javastudy.inner_observer;

import java.util.Observable;
import java.util.Observer;

public class ForcastConditions2 implements Observer {
  private float mTemperatrue;
  private float mPressure;
  private float mHumidity;
  
  public void display() {
    System.out.println("明天温度:" + (this.mTemperatrue + Math.random()));
    System.out.println("明天气压:" + (this.mPressure + 10*Math.random()));
    System.out.println("明天湿度:" + (this.mHumidity + Math.random()));
  }
  
  @Override
  public void update(Observable o, Object arg) {
    System.out.println(o);
    WeatherDataSt2.Data data = (WeatherDataSt2.Data)arg;
    this.mTemperatrue = data.mTemperatrue;
    this.mPressure = data.mPressure;
    this.mHumidity = data.mHumidity;
    display();
  }
}
