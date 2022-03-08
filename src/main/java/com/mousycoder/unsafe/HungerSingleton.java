package com.mousycoder.unsafe;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/5 11:22 AM
 */
public class HungerSingleton {

    private static HungerSingleton instance = new HungerSingleton();

    public static HungerSingleton getInstance(){
        return instance;
    }

    private HungerSingleton(){

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(HungerSingleton.getInstance());
            }).start();
        }
    }
}
