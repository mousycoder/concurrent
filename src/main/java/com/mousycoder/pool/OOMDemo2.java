package com.mousycoder.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/8 12:04 PM
 */
public class OOMDemo2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true){
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName());

                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
