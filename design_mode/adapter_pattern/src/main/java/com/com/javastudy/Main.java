package com.com.javastudy;

public class Main {
  public static void main(String[] args){
    GreenHeadDuck duck = new GreenHeadDuck();
    
    WildTurkey wildTurkey = new WildTurkey();
    
    Duck duck2turkeyAdapter = new TurkeyAdapter(wildTurkey);
    
    wildTurkey.gobble();
    wildTurkey.fly();
    duck.quack();
    duck.fly();
    duck2turkeyAdapter.quack();
    duck2turkeyAdapter.fly();
  }
}
