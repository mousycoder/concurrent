package com.mousycoder.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/6 9:05 PM
 */
public class LockDegrade {

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

        readLock.lock();
        writeLock.lock();

        writeLock.unlock();
        readLock.unlock();
        System.out.println("程序运行结束");
    }
}
