package com.mousycoder.communication.demo5;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 11:14 AM
 */
public class ThreadLocalDemo {

    ThreadLocal<Integer> num = ThreadLocal.withInitial(()->0);

    public void create(){
        Integer myNum = num.get();
        myNum++;
        System.out.println(Thread.currentThread().getName() + "---> " + myNum);
        num.set(myNum);
    }

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();

        for (int i = 1; i < 3; i++) {
            int finalI = i;
            new Thread(()->{

                while (true){
                    threadLocalDemo.create();
                    try {
                        Thread.sleep(finalI * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }).start();
        }
    }
}
