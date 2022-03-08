package com.mousycoder.interrupt;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/3 4:25 PM
 */
public class UnsafeWithStopDemo extends Thread {

    private int i = 0;

    private int j = 0;

    @Override
    public void run() {
        i++;
        try {
            sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j++;
    }

    public void printf() {
        System.out.println("i的值 " + i);
        System.out.println("j的值 " + j);
    }

    public static void main(String[] args) throws InterruptedException {
        UnsafeWithStopDemo thread = new UnsafeWithStopDemo();
        thread.start();
        Thread.sleep(1000L);
        thread.stop();
        thread.printf();
    }
}
