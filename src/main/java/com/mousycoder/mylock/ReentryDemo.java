package com.mousycoder.mylock;

import java.util.concurrent.locks.Lock;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/6 1:35 PM
 */
public class ReentryDemo {

    public Lock lock = new MyLock();

    public void methodA(){
        lock.lock();
        System.out.println("进入方法A");
        methodB();
        lock.unlock();
    }

    public void methodB(){
        lock.lock();
        System.out.println("进入方法B");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentryDemo reentryDemo = new ReentryDemo();
        reentryDemo.methodA();
    }

}
