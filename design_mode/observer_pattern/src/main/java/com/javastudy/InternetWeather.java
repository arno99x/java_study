package com.javastudy;

import com.javastudy.inner_observer.CurrentConditions2;
import com.javastudy.inner_observer.ForcastConditions2;
import com.javastudy.inner_observer.WeatherDataSt2;

public class InternetWeather {
  public static void main(String[] args){
    CurrentConditions currentConditions = new CurrentConditions();
    ForcastConditions forcastConditions = new ForcastConditions();
    WeatherDataSt weatherDataSt = new WeatherDataSt();
    
    weatherDataSt.registerObserver(currentConditions);
    weatherDataSt.registerObserver(forcastConditions);
    
    weatherDataSt.setData(30, 150, 40);
  
    CurrentConditions2 currentConditions2 = new CurrentConditions2();
    ForcastConditions2 forcastConditions2 = new ForcastConditions2();
    WeatherDataSt2 weatherDataSt2 = new WeatherDataSt2();
    weatherDataSt2.addObserver(currentConditions2);
    weatherDataSt2.addObserver(forcastConditions2);
  
    weatherDataSt2.setData(30, 150, 40);
  }
}
