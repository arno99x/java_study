package 手动写SpringMVC.myspringmvc.src.main.java.com.javastudy.controller;

import com.javastudy.annotation.MyController;
import com.javastudy.annotation.MyRequestMapping;
import com.javastudy.annotation.MyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MyController
@MyRequestMapping("/test")
public class TestController {
  @MyRequestMapping("/doTest")
  public void test1(HttpServletRequest request, HttpServletResponse response, @MyRequestParam("param") String param){
    System.out.println(param);
  }
  
  @MyRequestMapping("/doTest2")
  public void test2(HttpServletRequest request, HttpServletResponse response){
    try {
      response.getWriter().println("doTest2 method success!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
