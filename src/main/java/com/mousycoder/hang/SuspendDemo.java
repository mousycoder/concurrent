package com.mousycoder.hang;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/3 3:55 PM
 */
public class SuspendDemo implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "执行 run 方法，准备调用 suspend");
        Thread.currentThread().suspend();
        System.out.println(Thread.currentThread().getName() + "执行 run 方法，调用 suspend 结束");

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SuspendDemo());
        thread.start();
        Thread.sleep(3000);
        System.out.println("---");
        thread.resume();
    }
}
