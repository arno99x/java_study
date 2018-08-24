package com.javastudy;

public class CurrentConditions implements IObserver {
  
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
    System.out.println("Today mTemperatrue:" + this.mTemperatrue);
    System.out.println("Today mPressure:" + this.mPressure);
    System.out.println("Today mHumidity:" + this.mHumidity);
  }
}
