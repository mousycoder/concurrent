package com.mousycoder.communication.demo2;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 9:49 AM
 */
public class Producer implements Runnable {

    private Medium medium;

    public Producer(Medium medium) {
        this.medium = medium;
    }

    @Override
    public void run() {
        while (true){
            medium.put();
        }
    }
}
