package com.mousycoder.communication.demo6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 9:49 AM
 */
public class Medium {


    private volatile int num = 0;

    private static final int TOTAL = 20;

    private Lock lock = new ReentrantLock();

    private Condition consumerCondition = lock.newCondition();

    private Condition producerCondition = lock.newCondition();


    public void put() {
        lock.lock();

        try {
            if (num < TOTAL) {
                System.out.println("新增库存-> 当前库存 " + ++num);
                consumerCondition.signalAll();
            } else {
                try {
                    System.out.println("新增库存-> 库存已满 " + num);
                    producerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }

    }

    public void take() {

        lock.lock();
        try {
            if (num > 0) {
                System.out.println("消费库存-> 当前库存 " + --num);
                producerCondition.signalAll();
            } else {
                System.out.println("消费库存-> 库存不足 " + num);
                try {
                    consumerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }

    }


}
