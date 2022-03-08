package com.mousycoder.communication.demo;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 9:11 AM
 */
public class Demo1 {

    private static volatile boolean FLAG = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (!FLAG){
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("flag is false");
            }
            System.out.println("flag is true");
        }).start();

        Thread.sleep(1000L);


        new Thread(()->{
            FLAG = true;
        }).start();
    }
}
