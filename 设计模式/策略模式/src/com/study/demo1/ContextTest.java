package com.study.demo1;

public class ContextTest {
    public static void main(String[] args) {
        Context context = null;
        IStrategy strategy = new ConcreteStrategy1();
        context = new Context(strategy);
        context.excute();

        System.out.println("========================");

        IStrategy strategy1 = new ConcreteStrategy2();
        context = new Context(strategy1);
        context.excute();
    }
}
