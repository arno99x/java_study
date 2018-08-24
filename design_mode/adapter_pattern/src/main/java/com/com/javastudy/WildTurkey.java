package com.com.javastudy;

public class WildTurkey implements Turkey {
  @Override
  public void gobble() {
    System.out.println("Go Go");
  }
  
  @Override
  public void fly() {
    System.out.println("WildTurkey am flying");
  }
}
