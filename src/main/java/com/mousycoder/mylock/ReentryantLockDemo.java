package com.mousycoder.mylock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/6 2:01 PM
 */
public class ReentryantLockDemo {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
    }
}
