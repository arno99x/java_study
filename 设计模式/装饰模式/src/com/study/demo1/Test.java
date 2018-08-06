package com.study.demo1;

public class Test {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        SugarConcreteDecorator sugarConcreteDecorator = new SugarConcreteDecorator(component);
        MilkConcreteDecorator milkConcreteDecorator = new MilkConcreteDecorator(sugarConcreteDecorator);
        milkConcreteDecorator.operation();
    }
}
