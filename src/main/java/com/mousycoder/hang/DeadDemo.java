package com.mousycoder.hang;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/3 3:59 PM
 */
public class DeadDemo implements Runnable{

    private static Object object = new Object();

    @Override
    public void run() {
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+ "占用资源");
            Thread.currentThread().suspend();
        }
        System.out.println(Thread.currentThread().getName() + "释放资源");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DeadDemo(),"对比线程");
        thread.start();
        Thread.sleep(1000);
        thread.resume();


        Thread deadThread = new Thread(new DeadDemo(),"死锁线程");

        deadThread.start();
        deadThread.resume();

    }
}
