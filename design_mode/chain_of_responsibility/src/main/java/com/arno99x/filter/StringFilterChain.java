package com.arno99x.filter;

import org.apache.commons.lang3.StringUtils;

public class StringFilterChain extends AbstractFilterChain<String> {
  @Override
  public String doFilter(String s) {
    if (StringUtils.isBlank(s))return null;
    for (Filter filter : filters){
      s = (String) filter.doFilter(s);
    }
    return s;
  }
}
