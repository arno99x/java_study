package lesson1;

public class Test implements Runnable {
    public static void main(String[] args) {
        Test test = new Test();
        Thread thread1 = new Thread(test);
        thread1.setName("A");
        Thread thread2 = new Thread(test);
        thread2.setName("B");
        Thread thread3 = new Thread(test);
        thread3.setName("C");
        thread1.start();
        thread2.start();
        thread3.start();
    }


    @Override
    public void run() {
        for(int i=0 ; i<10000 ; i++){
            System.out.println(Thread.currentThread().getName() + "running !");
            SingleModel.getInstance();
        }
    }
}
