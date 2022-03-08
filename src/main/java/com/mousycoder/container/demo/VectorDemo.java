package com.mousycoder.container.demo;

import java.util.Iterator;
import java.util.Vector;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 3:49 PM
 */
public class VectorDemo {

    public static void main(String[] args) {
        Vector<String> stringVector = new Vector<>();
        for (int i = 0; i < 1000; i++) {
            stringVector.add("demo" + i);
        }
//
//        stringVector.forEach(e->{
//            if (e.equals("demo3")){
//                stringVector.remove(e);
//            }
//            System.out.println(e);
//        });


        Iterator<String> iterator = stringVector.iterator();

//        while (iterator.hasNext()){
//            String next = iterator.next();
//            if (next.equals("demo2")){
//                iterator.remove();
//            }
//        }

//        for (int i = 0; i < 4; i++) {
//            new Thread(() -> {
//                synchronized (stringVector) {
//                    while (iterator.hasNext()) {
//                        String next = iterator.next();
//                        if (next.equals("demo2")) {
//                            iterator.remove();
//                        }
//                    }
//                }
//
//            }).start();
//        }




    }

}
