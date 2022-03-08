package com.mousycoder.atomic.demo1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 2:36 PM
 */
public class Demo1 {

    public static AtomicInteger sum = new AtomicInteger(0);

    public static void inCreate(){
        sum.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    inCreate();
                    System.out.println(sum);
                }
            }).start();
        }
    }

}
