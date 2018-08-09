package com.study.demo1;

/**
 * 特点：饿汉式会提前进行实例化，没有延迟加载，不管是否使用都会有一个已经初始化的实例在内存中，但不会出现懒汉式中的多线程问题。
 */
public class EHSingleton {
//    private static Singleton instance = new Singleton();
//    private Singleton(){}
//    private static Singleton getInstance(){
//        return instance;
//    }
}
