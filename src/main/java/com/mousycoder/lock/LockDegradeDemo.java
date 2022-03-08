package com.mousycoder.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/6 9:11 PM
 */
public class LockDegradeDemo {

    private int i = 0;

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();

    public void doSomething() {
        writeLock.lock();

        try {
            i++;
            readLock.lock();
        } finally {
            writeLock.unlock();
        }

        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            if (i == 1) {
                System.out.println("i 的值是 1");
            } else {
                System.out.println("i 的值是" + i);
            }
        } finally {
            readLock.unlock();
        }

    }

    public static void main(String[] args) {
        LockDegradeDemo lockDegradeDemo = new LockDegradeDemo();
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                lockDegradeDemo.doSomething();
            }).start();
        }
    }
}
