package com.mousycoder.priority;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/3 10:25 PM
 */
public class PriorityDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().getName());
            }
        },"线程1");

        Thread thread2 = new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().getName());
            }
        },"线程2");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }
}
