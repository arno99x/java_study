package 手动写SpringMVC.myspringmvc.src.main.java.com.javastudy.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestMapping {
  /**
   * 表示访问该方法的url
   * @return
   */
  String value() default "";
}
