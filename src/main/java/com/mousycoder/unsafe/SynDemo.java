package com.mousycoder.unsafe;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/5 11:02 AM
 */
public class SynDemo {

    public synchronized void out() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5000L);
    }

    public static synchronized void statiout() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5000L);
    }

    private Object lock = new Object();


    public void myOut() throws InterruptedException {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5000L);
        }

    }

    public static void main(String[] args) {
        SynDemo synDemo1 = new SynDemo();
        SynDemo synDemo2 = new SynDemo();

        new Thread(()->{
            try {
                synDemo1.myOut();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(()->{
            try {
                synDemo1.myOut();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
