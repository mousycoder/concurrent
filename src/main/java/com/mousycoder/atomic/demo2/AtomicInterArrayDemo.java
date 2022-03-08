package com.mousycoder.atomic.demo2;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 2:49 PM
 */
public class AtomicInterArrayDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2};

        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);
        int i = atomicIntegerArray.addAndGet(1, 8);
        System.out.println(i);

        int i1 = atomicIntegerArray.accumulateAndGet(0, 2, ((left, right) ->
                left > right ? left : right));
        System.out.println(i1);
    }
}
