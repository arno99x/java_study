package com.arno99x.filter;

public interface Filter<T> {
  T doFilter(T msg);
}
