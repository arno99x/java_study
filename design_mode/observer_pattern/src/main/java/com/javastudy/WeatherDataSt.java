package com.javastudy;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSt implements ISubject{
  private float mTemperatrue;
  private float mPressure;
  private float mHumidity;
  
  private List<IObserver> observers = new ArrayList<>();
  
  public WeatherDataSt() {
  
  }
  
  public float getmTemperatrue() {
    return mTemperatrue;
  }
  
  public void setmTemperatrue(float mTemperatrue) {
    this.mTemperatrue = mTemperatrue;
  }
  
  public float getmPressure() {
    return mPressure;
  }
  
  public void setmPressure(float mPressure) {
    this.mPressure = mPressure;
  }
  
  public float getmHumidity() {
    return mHumidity;
  }
  
  public void setmHumidity(float mHumidity) {
    this.mHumidity = mHumidity;
  }
  
  public void dataChange(){
    notifyObservers();
  }
  
  public void setData(float mTemperatrue, float mPressure, float mHumidity){
    this.mTemperatrue = mTemperatrue;
    this.mPressure = mPressure;
    this.mHumidity = mHumidity;
    dataChange();
  }
  
  @Override
  public void registerObserver(IObserver observer) {
    if (observer == null) return;
    observers.add(observer);
  }
  
  @Override
  public void removeObserver(IObserver observer) {
    if (observer == null) return;
    observers.remove(observer);
  }
  
  @Override
  public void notifyObservers() {
    observers.stream().forEach(observer -> {
      observer.update(getmTemperatrue(), getmPressure(), getmHumidity());
    });
  }
}
