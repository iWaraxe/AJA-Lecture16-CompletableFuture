// File: Ex01ThreadSafeClass.java
// Package: com.coherentsolutions.advanced.java.section04

package com.coherentsolutions.advanced.java.section04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class demonstrates a thread-safe design using synchronization and encapsulation.
 */
public class Ex01ThreadSafeClass {

    private int balance;
    private final Lock lock = new ReentrantLock(); // Using a lock for thread safety

    public Ex01ThreadSafeClass(int initialBalance) {
        this.balance = initialBalance;
    }

    // Thread-safe method to deposit money
    public void deposit(int amount) {
        lock.lock(); // Acquiring the lock
        try {
            balance += amount;
        } finally {
            lock.unlock(); // Always release the lock in a finally block
        }
    }

    // Thread-safe method to get the balance
    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
