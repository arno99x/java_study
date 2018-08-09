package com.study.demo1;

/**
 * @author arno
 */
public class MilkConcreteDecorator extends Decorator{

    public MilkConcreteDecorator(Component component) {
        super(component);
    }
    @Override
    public void operation(){
        System.out.print("加奶");
        super.operation();
    }


}
