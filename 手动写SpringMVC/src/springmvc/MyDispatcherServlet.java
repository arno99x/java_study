package com.vincent.mybatis.spring.springmvc;

import com.vincent.mybatis.spring.annotation.MyController;
import com.vincent.mybatis.spring.annotation.MyRequestMapping;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class MyDispatcherServlet extends HttpServlet {
  private Properties properties = new Properties();
  private List<String> classNames = new ArrayList<>();
  private Map<String, Object> ioc = new HashMap<>();
  private Map<String, Method> handlerMapping = new HashMap<>();
  private Map<String, Object> controllerMap = new HashMap<>();
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    //加载配置文件
    doLoadConfig(config.getInitParameter("scanPackage"));
    //初始化所有相关关联的类，扫面用户设定的包下面所有的类
    doScanner(properties.getProperty("scanPackage"));
    //拿到扫描到的类，通过反射机制，实例化，并且放到IOC容器中
    doInstance();
    //初始化HandlerMapping（将url和method对应上）
    initHandlerMapping();
  }
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doPost(req, resp);
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
  }
  
  private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception{
    if (handlerMapping.isEmpty()){
      return;
    }
    
    String url = request.getRequestURI();
    String contextPath = request.getContextPath();
    
    url = url.replace(contextPath, "").replaceAll("/+", "/");
    
    if (!this.handlerMapping.containsKey(url)){
      response.getWriter().write("404 NOT FOUND");
      return;
    }
    
    Method method = this.handlerMapping.get(url);
    
    Class<?>[] parameterTypes = method.getParameterTypes();
    
    //获取请求的参数
    Map<String, String[]> parameterMap = request.getParameterMap();
    
    //保存参数值
    Object[] paramValues = new Object[parameterTypes.length];
    
    //方法的参数列表
    for (int i = 0; i < parameterTypes.length; i++){
      //根据参数名称
      String requestParam = parameterTypes[i].getSimpleName();
      if (requestParam.equals("HttpServletRequest")){
        paramValues[i] = request;
        continue;
      }
      if (requestParam.equals("HttpServletResponse")){
        paramValues[i]=response;
        continue;
      }
      
      if (requestParam.equals("String")){
        for (Map.Entry<String, String[]> param : parameterMap.entrySet()){
          String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "").replaceAll(",\\s", "");
          paramValues[i] = value;
        }
      }
      try{
        method.invoke(this.controllerMap.get(url), paramValues);
      }catch (Exception e){
        e.printStackTrace();
      }
    }
  }
  
  private void doLoadConfig(String location){
    //把wen.xml的contextConfigLocation对应的value值的文件加载到流里面
    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(location);
    
    try{
      //用Properties文件加载文件里的内容
      properties.load(inputStream);
    }catch (IOException e){
      e.printStackTrace();
    }finally {
      if (null != inputStream){
        try{
          inputStream.close();
        }catch (IOException e){
          e.printStackTrace();
        }
      }
    }
  }
  
  private void doScanner(String packageName){
    //把所有的.替换成/
    URL url = this.getClass().getClassLoader().getResource("/" + packageName.replaceAll("\\.", "/"));
    File dir = new File(url.getFile());
    for (File file : dir.listFiles()){
      if (file.isDirectory()){
        doScanner(packageName+"."+file.getName());
      }else {
        String className = packageName+ "." + file.getName().replace(".class", "");
        classNames.add(className);
      }
    }
  }
  
  private void doInstance(){
    if (classNames.isEmpty()){
      return;
    }
    for (String className : classNames){
      try {
        Class<?> clazz = Class.forName(className);
        if (clazz.isAnnotationPresent(MyController.class)){
          ioc.put(toLowerFirstWord(clazz.getSimpleName()), clazz.newInstance());
        }else {
          continue;
        }
      }catch (Exception e){
        e.printStackTrace();
        continue;
      }
    }
  }
  
  private String toLowerFirstWord(String name){
    char[] charArray = name.toCharArray();
    charArray[0] += 32;
    return String.valueOf(charArray);
  }
  
  private void initHandlerMapping() {
    if (ioc.isEmpty()){
      return;
    }
    try{
      for (Map.Entry<String, Object> entry : ioc.entrySet()){
        Class<? extends Object> clazz = entry.getValue().getClass();
        if (!clazz.isAnnotationPresent(MyController.class)){
          continue;
        }
        
        //拼url时，是controller头的url拼上方法上的url
        String baseUrl = "";
        if (clazz.isAnnotationPresent(MyRequestMapping.class)){
          MyRequestMapping annotation = clazz.getAnnotation(MyRequestMapping.class);
          baseUrl = annotation.value();
        }
        Method[] methods = clazz.getMethods();
        for (Method method : methods){
          if (!method.isAnnotationPresent(MyRequestMapping.class)){
            continue;
          }
          MyRequestMapping annotation = method.getAnnotation(MyRequestMapping.class);
          String url = annotation.value();
          
          url = (baseUrl + "/" + url).replaceAll("/+", "/");
          handlerMapping.put(url, method);
          controllerMap.put(url, clazz.newInstance());
          System.out.println(url + "," + method);
        }
      }
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
