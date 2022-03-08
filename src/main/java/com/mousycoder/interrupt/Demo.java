package com.mousycoder.interrupt;

import java.lang.reflect.WildcardType;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/3 4:25 PM
 */
public class Demo implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Demo());
        thread.start();
        Thread.sleep(2000L);
        thread.stop();
    }
}
