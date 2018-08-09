package ticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketDemoThread implements Runnable{
    /**
     * private Integer nums = 5;
     * 因为没有原子性和可见性，执行结果可能是这样
     * 窗口售票窗口1卖出了一张票，还剩3张
     * 窗口售票窗口3卖出了一张票，还剩2张
     * 窗口售票窗口2卖出了一张票，还剩3张
     * 窗口售票窗口3卖出了一张票，还剩0张
     * 窗口售票窗口1卖出了一张票，还剩1张
     */

    /**
     *  private volatile Integer nums = 5;
     *  加上volatile使nums变量线程可见，但是也不对，结果可能是下面这样
     * 窗口售票窗口2卖出了一张票，还剩2张
     * 窗口售票窗口1卖出了一张票，还剩2张
     * 窗口售票窗口1卖出了一张票，还剩0张
     * 窗口售票窗口3卖出了一张票，还剩2张
     * 窗口售票窗口2卖出了一张票，还剩1张
     */

    /**
     * private AtomicInteger nums = new AtomicInteger(5);
     * 用元子变量也没有解决这个问题，会出现如下结果。
     * nums.getAndIncrement()   获取并自增
     * nums.getAndDecrement();  获取并自减
     * nums.get()               获取
     *
     * 窗口售票窗口1卖出了一张票，还剩3张
     * 窗口售票窗口3卖出了一张票，还剩2张
     * 窗口售票窗口2卖出了一张票，还剩3张
     * 窗口售票窗口3卖出了一张票，还剩0张
     * 窗口售票窗口1卖出了一张票，还剩1张
     */
    private int nums = 5;

    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        try {
            while (nums > 0){
                nums--;
                System.out.println("窗口"+Thread.currentThread().getName()+"卖出了一张票，还剩"+nums+"张");
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TicketDemoThread ticketDemoThread = new TicketDemoThread();
        Thread thread1 = new Thread(ticketDemoThread,"售票窗口1");
        Thread thread2 = new Thread(ticketDemoThread,"售票窗口2");
        Thread thread3 = new Thread(ticketDemoThread,"售票窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
