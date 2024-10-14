// File: Ex04CopyOnWriteArrayList.java
// Package: com.coherentsolutions.advanced.java.section03

package com.coherentsolutions.advanced.java.section03;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This class demonstrates the use of CopyOnWriteArrayList for thread-safe operations.
 */
public class Ex04CopyOnWriteArrayList {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

        // Writing to the list from multiple threads
        Runnable writeTask = () -> {
            for (int i = 0; i < 5; i++) {
                list.add(Thread.currentThread().getName() + "-" + i);
            }
        };

        // Reading from the list from multiple threads
        Runnable readTask = () -> {
            for (String item : list) {
                System.out.println(Thread.currentThread().getName() + " reading: " + item);
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
