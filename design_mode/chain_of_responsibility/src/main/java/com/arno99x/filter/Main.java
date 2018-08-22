package com.arno99x.filter;

public class Main {
  public static void main(String[] args){
    String msg = "_测试责任链模式";
    StringMsgProcessor processor = new StringMsgProcessor();
    StringFilterChain filterChain = new StringFilterChain();
    StringFilter stringFilter = new StringFilter();
    filterChain.addFilter(stringFilter);
    processor.setFilterChain(filterChain);
    processor.setMsg(msg);
    String result = processor.process();
    System.out.println(result);
  }
}
