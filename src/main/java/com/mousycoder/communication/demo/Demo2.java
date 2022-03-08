package com.mousycoder.communication.demo;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 9:11 AM
 */
public class Demo2 {

    private static volatile boolean FLAG = false;

    public static void main(String[] args) throws InterruptedException {

        Object obj = new Object();

        new Thread(() -> {
            while (!FLAG) {
                synchronized (obj) {
                    System.out.println("flag is false");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("flag is true");
        }).start();


        new Thread(() -> {
            while (!FLAG) {
                synchronized (obj) {
                    System.out.println("flag is false");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("flag is true");
        }).start();


        Thread.sleep(1000L);

        new Thread(() -> {
            FLAG = true;
            synchronized (obj){
                obj.notifyAll();
            }
        }).start();
    }
}
