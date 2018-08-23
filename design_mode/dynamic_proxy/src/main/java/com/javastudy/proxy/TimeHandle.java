package com.javastudy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandle<T> implements InvocationHandler {
  T target;
  
  public TimeHandle(T target){
    this.target = target;
  }
  
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    long start = System.currentTimeMillis();
    System.out.println("starttime:" + start);
    System.out.println(proxy.getClass().getName());
    Object result = method.invoke(target);
    long end = System.currentTimeMillis();
    System.out.println("endtime:" + end);
    return result;
  }
}
