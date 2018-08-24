package com.javastudy.inner_observer;

import java.util.Observable;

public class WeatherDataSt2 extends Observable {
  private float mTemperatrue;
  private float mPressure;
  private float mHumidity;
  
  public WeatherDataSt2() {
  
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
    //setChange 必须
    this.setChanged();
    notifyObservers(new Data(getmTemperatrue(), getmPressure(), getmHumidity()));
  }
  
  public void setData(float mTemperatrue, float mPressure, float mHumidity){
    this.mTemperatrue = mTemperatrue;
    this.mPressure = mPressure;
    this.mHumidity = mHumidity;
    dataChange();
  }
  
  public class Data {
    public float mTemperatrue;
    public float mPressure;
    public float mHumidity;
    
    public Data(float mTemperatrue, float mPressure, float mHumidity){
      this.mHumidity = mHumidity;
      this.mPressure = mPressure;
      this.mTemperatrue = mTemperatrue;
    }
  }
}
