// File: Ex03ConcurrentHashMap.java
// Package: com.coherentsolutions.advanced.java.section03

package com.coherentsolutions.advanced.java.section03;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * This class demonstrates the use of ConcurrentHashMap for thread-safe operations.
 */
public class Ex03ConcurrentHashMap {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Writing to the map from multiple threads
        Runnable writeTask = () -> {
            for (int i = 0; i < 5; i++) {
                map.put(Thread.currentThread().getName() + "-" + i, i);
            }
        };

        // Reading from the map from multiple threads
        Runnable readTask = () -> {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(Thread.currentThread().getName() + " reading: " + entry.getKey() + " -> " + entry.getValue());
            }
        };

        Thread writer1 = new Thread(writeTask);
        Thread writer2 = new Thread(writeTask);
        Thread reader = new Thread(readTask);

        writer1.start();
        writer2.start();
        reader.start();
    }
}
