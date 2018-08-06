package com.study.demo1;

/**
 * @author arno
 */
public class SugarConcreteDecorator  extends Decorator{

    public SugarConcreteDecorator(Component component) {
        super(component);
    }
    @Override
    public void operation(){
        System.out.print("加糖");
        super.operation();
    }
}
