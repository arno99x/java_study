package com.com.javastudy;

public class GreenHeadDuck implements Duck {
  @Override
  public void quack() {
    System.out.println("Ga Ga");
  }
  
  @Override
  public void fly() {
    System.out.println("GreenHeadDuck am flying");
  }
}
