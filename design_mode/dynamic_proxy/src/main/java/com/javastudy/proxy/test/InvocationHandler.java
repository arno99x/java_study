package com.javastudy.proxy.test;

import java.lang.reflect.Method;

public interface InvocationHandler {
  public void invoke(Object object, Method method);
}
