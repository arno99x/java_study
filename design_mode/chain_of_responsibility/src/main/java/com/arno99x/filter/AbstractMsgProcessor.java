package com.arno99x.filter;

public class AbstractMsgProcessor<T> {
  private T msg;
  public AbstractFilterChain<T> filterChain;
  
  public void setFilterChain(AbstractFilterChain<T> filterChain) {
    this.filterChain = filterChain;
  }
  
  public T getMsg() {
    return msg;
  }
  
  public void setMsg(T msg) {
    this.msg = msg;
  }
  
  public T process(){
    T s = msg;
    s = filterChain.doFilter(s);
    return s;
  }
}
