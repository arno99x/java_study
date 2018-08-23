package com.javastudy.proxy.test;

import java.util.Random;

public class Tank implements Moveable{
  @Override
  public void move() {
    System.out.println("Tank move");
    try {
      Thread.sleep(new Random().nextInt(10000));
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
