package com.mousycoder.guard;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/3 10:37 PM
 */
public class DaemonThreadDemo implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DaemonThreadDemo());
        thread.start();
        thread.setDaemon(true);
        Thread.sleep(2000L);
    }
}
