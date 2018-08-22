package com.study.thread.priority;

public class ThreadJoin {
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        Thread t = new Thread(runner);
        t.start();
        t.join();

        System.out.println("我想等t1完成后我再执行。。。");

    }

}

class Runner implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is runner");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
