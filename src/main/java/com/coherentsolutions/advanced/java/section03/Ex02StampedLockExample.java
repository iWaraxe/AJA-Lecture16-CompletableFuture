// File: Ex02StampedLockExample.java
// Package: com.coherentsolutions.advanced.java.section03

package com.coherentsolutions.advanced.java.section03;

import java.util.concurrent.locks.StampedLock;

/**
 * This class demonstrates the use of StampedLock with optimistic read locking.
 */
public class Ex02StampedLockExample {

    private static final StampedLock lock = new StampedLock();
    private static int sharedData = 0;

    public static void main(String[] args) {
        Runnable readTask = () -> {
            long stamp = lock.tryOptimisticRead(); // Acquiring an optimistic read lock
            try {
                if (!lock.validate(stamp)) { // Check if the stamp is still valid
                    stamp = lock.readLock();
                }
                System.out.println(Thread.currentThread().getName() + " is reading: " + sharedData);
            } finally {
                if (StampedLock.isReadLockStamp(stamp)) {
                    lock.unlockRead(stamp); // Releasing the read lock
                }
            }
        };

        Runnable writeTask = () -> {
            long stamp = lock.writeLock(); // Acquiring the write lock
            try {
                sharedData++;
                System.out.println(Thread.currentThread().getName() + " is writing: " + sharedData);
            } finally {
                lock.unlockWrite(stamp); // Releasing the write lock
            }
        };

        Thread thread1 = new Thread(readTask);
        Thread thread2 = new Thread(writeTask);
        Thread thread3 = new Thread(readTask);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
