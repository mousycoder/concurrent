package com.mousycoder.pool;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/8 9:31 AM
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>(20);

//        for (int i = 0; i < 100; i++) {
//            linkedBlockingQueue.put(()->{
//                System.out.println(Thread.currentThread().getName());
//            });
//        }


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 30, 3000L, TimeUnit.SECONDS, linkedBlockingQueue,new CustomPolicy());
//        threadPoolExecutor.prestartCoreThread();


        for (int i = 0; i < 60; i++) {
            threadPoolExecutor.submit(()->{
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadPoolExecutor.getActiveCount());
            });
        }



//        for (int i = 0; i < 5; i++) {
//            Future<?> submit = threadPoolExecutor.submit(() -> {
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName());
//            });
//        }
//        Future<String> submit = null;
//        for (int i = 0; i < 10; i++) {
//            submit = threadPoolExecutor.submit(new CallableDemo());
//        }
//
//        for (int i = 0; i < 100; i++) {
//            System.out.println(submit.get());
//        }
        
    }
}
