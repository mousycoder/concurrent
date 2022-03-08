package com.mousycoder.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/8 11:30 AM
 */
public class OOMDemo3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 100; i++) {
            Future<Integer> submit = executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                return 1 / 0;
            });
            submit.get();

        }

    }
}
