package com.mousycoder.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/6 4:56 PM
 */
public class ReentrantReadWriteLockDemo {

    private int i = 0;

    private int j = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    public void out() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "i = " + i + " j = " + j);
        } finally {
            readLock.unlock();
        }
    }

    public void inCreate() {
        writeLock.lock();
        try {
            i++;
            Thread.sleep(500L);
            j++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();

        new Thread(() -> {
            demo.out();
        },"读线程1").start();

        new Thread(() -> {
            demo.out();
        },"读线程2").start();

//        new Thread(() -> {
//            demo.inCreate();
//        },"写线程").start();
    }
}
