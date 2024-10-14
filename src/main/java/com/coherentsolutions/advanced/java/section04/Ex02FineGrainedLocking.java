// File: Ex02FineGrainedLocking.java
// Package: com.coherentsolutions.advanced.java.section04

package com.coherentsolutions.advanced.java.section04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class demonstrates fine-grained locking to avoid unnecessary contention.
 */
public class Ex02FineGrainedLocking {

    private final Lock depositLock = new ReentrantLock();
    private final Lock withdrawLock = new ReentrantLock();
    private int balance = 0;

    // Locking only for deposit operations
    public void deposit(int amount) {
        depositLock.lock();
        try {
            balance += amount;
        } finally {
            depositLock.unlock();
        }
    }

    // Locking only for withdraw operations
    public void withdraw(int amount) {
        withdrawLock.lock();
        try {
            balance -= amount;
        } finally {
            withdrawLock.unlock();
        }
    }

    public int getBalance() {
        return balance; // No lock needed for reading (only safe if balance is not volatile)
    }
}
