package com.study.demo1;

/**
 * ConcreteComponent
 * 接受附加的责任
 */
public class ConcreteComponent implements Component{
    @Override
    public void operation() {
        System.out.println("的咖啡");
    }
}
