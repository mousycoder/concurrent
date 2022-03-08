package com.mousycoder;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/3 9:24 AM
 */
public class DeadLockDemo {

    private static final Object HAIR_A = new Object();
    private static final Object HAIR_B = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (HAIR_A){

                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (HAIR_B){
                    System.out.println("A成功的抓住B的头发");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (HAIR_B){
                synchronized (HAIR_A){
                    System.out.println("B成功的抓住A的头发");
                }
            }
        }).start();
    }



}
