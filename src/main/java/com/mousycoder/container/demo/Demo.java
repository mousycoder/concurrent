package com.mousycoder.container.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 3:58 PM
 */
public class Demo {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> stringList = Collections.synchronizedList(arrayList);

        for (int i = 0; i < 1000; i++) {
            stringList.add("demo" + i);
        }


//        stringList.forEach(e -> {
//            if (e.equals("demo3")) {
//                stringList.remove(e);
//            }
//            System.out.println(e);
//        });



        Iterator<String> iterator = stringList.iterator();

//        while (iterator.hasNext()){
//            String next = iterator.next();
//            if (next.equals("demo2")){
//                iterator.remove();
//            }
//        }


        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                synchronized (stringList) {
                    while (iterator.hasNext()) {
                        String next = iterator.next();
                        if (next.equals("demo2")) {
                            iterator.remove();
                        }
                    }
                }

            }).start();
        }

    }
}
