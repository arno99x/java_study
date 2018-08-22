package com.arno99x.filter;

public class StringFilter implements Filter<String> {
  @Override
  public String doFilter(String msg) {
    String r = msg.replace("测试", "处理");
    return r;
  }
}
