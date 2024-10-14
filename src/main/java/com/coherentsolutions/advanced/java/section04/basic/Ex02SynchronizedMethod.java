// File: Ex02SynchronizedMethod.java
// Package: com.coherentsolutions.advanced.java.section04

package com.coherentsolutions.advanced.java.section04.basic;

/**
 * This class demonstrates the use of synchronized methods for thread-safe access.
 */
public class Ex02SynchronizedMethod {

    private int counter = 0;

    public synchronized void increment() {
        counter++; // Thread-safe increment
    }

    public synchronized int getCounter() {
        return counter; // Thread-safe read
    }
}
