package com.javastudy.proxy.test;

import com.javastudy.proxy.Tank;

public class Test {
  //无效测试
  public static void main(String[] args) throws Exception{
    Tank tank = new Tank();
    TimeHandler timeHandler = new TimeHandler<Tank>(tank);
  
    Tank proxyInstance = (Tank)Proxy.newProxyInstance(Tank.class.getClassLoader(), Tank.class, timeHandler);
    
    proxyInstance.move();
  }
}
