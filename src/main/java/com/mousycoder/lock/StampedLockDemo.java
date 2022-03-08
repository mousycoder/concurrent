package com.mousycoder.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 8:38 AM
 */
public class StampedLockDemo {

    private double x,y;

    private final StampedLock s1 = new StampedLock();

    void move(double x1,double y1){
        long stamp = s1.writeLock();

        try {
            x +=x1;
            y +=y1;
        } finally {
            s1.unlockWrite(stamp);
        }
    }

    double distanceFromOrigin(){
        long stamp = s1.tryOptimisticRead();

        double currentX = x, currentY = y;

        if (!s1.validate(stamp)){
            stamp = s1.readLock();

            try {
                currentX = x;
                currentY = y;
            } finally {
                s1.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    void moveIfAtOrigin(double newX, double newY){
        long stamp = s1.readLock();
        try {
            while ( x == 0.0 && y == 0.0){
                long ws = s1.tryConvertToWriteLock(stamp);

                if (ws != 0L){
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                }else {
                    s1.unlockRead(stamp);
                    stamp = s1.writeLock();
                }


            }
        }finally {
            s1.unlock(stamp);
        }
    }

    public static void main(String[] args) {
        StampedLockDemo stampedLockDemo = new StampedLockDemo();
        stampedLockDemo.move(1.1,2);
        double v = stampedLockDemo.distanceFromOrigin();
        System.out.println(v);
        stampedLockDemo.moveIfAtOrigin(1,1);

    }




}
