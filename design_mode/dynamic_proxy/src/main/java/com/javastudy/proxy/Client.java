package com.javastudy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
  public static void main(String[] args) throws Exception{
    Moveable moveable = new Tank();
    TimeHandle timeHandle = new TimeHandle<Moveable>(moveable);
    
    InvocationHandler h = new TimeHandle(moveable);
  
    Moveable proxyInstance = (Moveable) Proxy.newProxyInstance(Moveable.class.getClassLoader(), new Class<?>[]{Moveable.class}, timeHandle);
  
    proxyInstance.move();
  }
}
