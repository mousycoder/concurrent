package com.mousycoder.atomic.demo1;

import java.util.concurrent.atomic.LongAccumulator;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 2:41 PM
 */
public class Demo2 {

    public static void main(String[] args) {
        LongAccumulator longAccumulator = new LongAccumulator((left, right) ->
                left > right ? left : right, 0L
        );

        longAccumulator.accumulate(3L);
        System.out.println(longAccumulator.get());

        longAccumulator.accumulate(5L);
        System.out.println(longAccumulator.get());

    }
}
