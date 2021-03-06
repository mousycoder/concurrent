package com.mousycoder.hang;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/3 3:59 PM
 */
public class WaitDemo implements Runnable{

    private static Object object = new Object();

    private static Object waitObj = new Object();

    @Override
    public void run() {
        synchronized (waitObj){
            System.out.println(Thread.currentThread().getName()+ "占用资源");
            try {
                waitObj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "释放资源");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new WaitDemo(),"对比线程");
        thread.start();

        Thread thread2 = new Thread(new WaitDemo(),"对比线程2");
        thread2.start();
        Thread.sleep(3000);


        synchronized (waitObj){
            waitObj.notify();
        }

        synchronized (waitObj){
            waitObj.notify();
        }
    }
}
