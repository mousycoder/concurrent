package com.mousycoder.mylock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/6 4:25 PM
 */
public class ReentrantLockDebugDemo {

    private int i = 0;

    private ReentrantLock reentrantLock = new ReentrantLock();


    public void inCreate(){
        reentrantLock.lock();
        try {
            i++;
            System.out.println(i);
        } finally {
            reentrantLock.unlock();
        }
    }


    public static void main(String[] args) {
        ReentrantLockDebugDemo reentrantLockDebugDemo = new ReentrantLockDebugDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                reentrantLockDebugDemo.inCreate();
            }).start();
        }


    }
}
