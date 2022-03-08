package com.mousycoder.jvm;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/8 3:01 PM
 */
public class Demo2 {

    static int x = 0, y = 0, a = 0, b = 0;


    public static void main(String[] args) throws InterruptedException {

        int i = 0 ;
        boolean flag = true;

        while (flag){
            i++;
            Thread thread1 = new Thread(() -> {
                a = 1;
                x = b;
            });


            Thread thread2 = new Thread(() -> {
                b = 1;
                y = a;
            });

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            System.out.println( "第"+i+"次" +  "x-->" + x + "y ->>" + y);

            if (x == 0 && y ==0 ){
                flag = false;
            }else {
                x = 0;
                y = 0;
                a = 0;
                b = 0;
            }

        }

    }
}
