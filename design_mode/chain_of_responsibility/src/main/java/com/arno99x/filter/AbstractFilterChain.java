package com.arno99x.filter;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFilterChain<T> {
  List<Filter<T>> filters = new ArrayList<>();
  
  public void addFilter(Filter<T> filter) {
    if (filter == null)return;
    this.filters.add(filter);
  }
  
  public void batchAddFilter(List<Filter<T>> filterList){
    if (CollectionUtils.isEmpty(filterList))return;
    this.filters.addAll(filterList);
  }
  
  public abstract T doFilter(T s);
}
