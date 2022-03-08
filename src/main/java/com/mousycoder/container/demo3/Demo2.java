package com.mousycoder.container.demo3;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 8:15 PM
 */
public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();
        strings.add("111");
        strings.offer("111");
        strings.put("111");


        String remove = strings.remove();
        strings.poll();
        strings.take();

    }
}
