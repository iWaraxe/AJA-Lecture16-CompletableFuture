// File: Ex01ReadWriteLockExample.java
// Package: com.coherentsolutions.advanced.java.section03

package com.coherentsolutions.advanced.java.section03;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * This class demonstrates the use of ReadWriteLock for thread-safe read and write operations.
 */
public class Ex01ReadWriteLockExample {

    private static final ReadWriteLock lock = new ReentrantReadWriteLock();
    private static int sharedData = 0;

    public static void main(String[] args) {
        Runnable readTask = () -> {
            lock.readLock().lock(); // Acquiring the read lock
            try {
                System.out.println(Thread.currentThread().getName() + " is reading: " + sharedData);
            } finally {
                lock.readLock().unlock(); // Releasing the read lock
            }
        };

        Runnable writeTask = () -> {
            lock.writeLock().lock(); // Acquiring the write lock
            try {
                sharedData++;
                System.out.println(Thread.currentThread().getName() + " is writing: " + sharedData);
            } finally {
                lock.writeLock().unlock(); // Releasing the write lock
            }
        };

        // Creating threads to read and write
        Thread thread1 = new Thread(readTask);
        Thread thread2 = new Thread(writeTask);
        Thread thread3 = new Thread(readTask);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
