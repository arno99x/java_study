package com.javastudy;

public class ForcastConditions implements IObserver {
  private float mTemperatrue;
  private float mPressure;
  private float mHumidity;
  
  @Override
  public void update(float mTemperatrue, float mPressure, float mHumidity) {
    this.mTemperatrue = mTemperatrue;
    this.mPressure = mPressure;
    this.mHumidity = mHumidity;
    display();
  }
  
  public void display() {
    System.out.println("明天温度:" + (this.mTemperatrue + Math.random()));
    System.out.println("明天气压:" + (this.mPressure + 10*Math.random()));
    System.out.println("明天湿度:" + (this.mHumidity + Math.random()));
  }
}
