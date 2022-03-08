package com.mousycoder.tool;

import java.util.concurrent.Exchanger;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 10:00 PM
 */
public class ExchangerDemo {

    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<>();
        String str1 = "h1";
        String str2 = "h2";

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "初始值--->" + str1);
            try {
                String exchange = stringExchanger.exchange(str1);
                System.out.println(Thread.currentThread().getName() + " 交换后--->" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程1").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "初始值--->" + str2);
            try {
                String exchange = stringExchanger.exchange(str2);
                System.out.println(Thread.currentThread().getName() + " 交换后--->" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程2").start();


        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "初始值--->" + str2);
            try {
                String exchange = stringExchanger.exchange(str2);
                System.out.println(Thread.currentThread().getName() + " 交换后--->" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程3").start();


    }
}
