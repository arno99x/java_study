package com.study.thread.priority;

public class PriorityExample{
    public static void main(String[] args){
        PThread pt = new PThread();
        pt = new PThread();

        Thread t1 = new Thread(pt,"t1");
        Thread t2 = new Thread(pt,"t2");
        Thread t3 = new Thread(pt,"t3");
        Thread t4 = new Thread(pt,"t4");
        Thread t5 = new Thread(pt,"t5");

        t1.setPriority(1);
        t2.setPriority(2);
        t3.setPriority(3);
        t4.setPriority(4);
        t5.setPriority(5);



        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class PThread implements Runnable{


    @Override
    public void run(){
        for(int i=0; i<7; i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
