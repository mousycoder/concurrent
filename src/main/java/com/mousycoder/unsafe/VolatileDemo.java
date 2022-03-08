package com.mousycoder.unsafe;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/5 11:18 AM
 */
public class VolatileDemo implements Runnable {

    private static volatile boolean FLAG = true;

    @Override
    public void run() {
        while (FLAG){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
