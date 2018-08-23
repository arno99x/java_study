package com.javastudy.proxy.test;

import java.lang.reflect.Method;

public class TimeHandler<T> implements InvocationHandler {
  T target;
  public TimeHandler(T target) {
    this.target = target;
  }
  @Override
  public void invoke(Object object, Method method) {
    long start = System.currentTimeMillis();
    System.out.println("starttime:" + start);
    System.out.println(object.getClass().getName());
    try {
      method.invoke(target);
    } catch (Exception e) {
      e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println("time:" + (end-start));
  }
}
