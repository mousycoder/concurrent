package com.mousycoder.communication.demo2;

import java.lang.reflect.WildcardType;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 9:49 AM
 */
public class Consumer implements Runnable{

    private Medium medium;

    public Consumer(Medium medium) {
        this.medium = medium;
    }

    @Override
    public void run() {
        while (true){
            medium.take();
        }
    }
}
