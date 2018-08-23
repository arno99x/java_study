package com.javastudy.proxy.test;

import java.lang.reflect.Constructor;
import java.util.Objects;

public class Proxy {
  public static Object newProxyInstance(ClassLoader loader, Class<?> infce, InvocationHandler handler) throws Exception {
    Objects.requireNonNull(handler);
    //废弃，不能用
    if (infce == null)throw new Exception("is null");
    if (infce.isInterface())throw new Exception("is interface");
    /**
     * 出错原因：Tank的构造器没有InvocationHandler相关的parameterType
     */
    Constructor constructor = infce.getConstructor(new Class<?>[]{InvocationHandler.class});
    constructor.setAccessible(true);
    Object object = constructor.newInstance(new Class<?>[]{handler.getClass()});
    return object;
  }
}
