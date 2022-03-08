package com.mousycoder.communication.demo2;

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

    public synchronized void put(){
         if (num < TOTAL){
             System.out.println("新增库存-> 当前库存 " + ++num);
             notifyAll();
         }else {
             try {
                 System.out.println("新增库存-> 库存已满 " + num);
                 wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }

    public synchronized void take(){
        if (num > 0) {
            System.out.println("消费库存-> 当前库存 " + --num);
            notifyAll();
        }else {
            System.out.println("消费库存-> 库存不足 " + num);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
