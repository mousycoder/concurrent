package com.mousycoder.unsafe;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/5 11:25 AM
 */
public class LazySingleton {

    private static volatile LazySingleton lazySingleton = null;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (LazySingleton.class) {
                if (lazySingleton == null){
                    lazySingleton = new LazySingleton();
                }

            }

        }
        return lazySingleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(LazySingleton.getInstance());
            }).start();
        }
    }


}
