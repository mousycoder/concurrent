package com.mousycoder.mylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/6 1:28 PM
 */
public class MyLock implements Lock {

    private boolean isHoldLock = false;

    private int reentryCount = 0;

    private Thread holdLockThread = null;


    @Override
    public synchronized void lock() {
        if (isHoldLock && Thread.currentThread() != holdLockThread) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        holdLockThread = Thread.currentThread();
        isHoldLock = true;
        reentryCount++;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread()  == holdLockThread){
            reentryCount--;
            if (reentryCount == 0) {
                notify();
                isHoldLock = false;
            }
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
