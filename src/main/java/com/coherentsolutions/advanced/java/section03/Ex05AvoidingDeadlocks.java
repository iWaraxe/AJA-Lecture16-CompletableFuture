// File: Ex05AvoidingDeadlocks.java
// Package: com.coherentsolutions.advanced.java.section03

package com.coherentsolutions.advanced.java.section03;

/**
 * Best practices to avoid deadlocks in multithreaded applications.
 */
public class Ex05AvoidingDeadlocks {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Runnable task1 = () -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " acquired lock1, waiting for lock2");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock2");
                }
            }
        };

        Runnable task2 = () -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " acquired lock2, waiting for lock1");
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock1");
                }
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
}

// Summary
// --------------------
// - Advanced synchronization techniques like `ReadWriteLock` and `StampedLock` help improve performance by allowing multiple readers while restricting writers.
// - Thread-safe collections like `ConcurrentHashMap` and `CopyOnWriteArrayList` simplify multithreaded programming by handling synchronization internally.
// - Best practices, including immutability, thread confinement, and avoiding deadlocks, are crucial for writing robust concurrent applications.

// Up Next: We’ll explore how to use advanced concurrency utilities like ForkJoinPool and Phaser!

