// File: Ex02CompletableFutureBasic.java
// Package: com.coherentsolutions.advanced.java.section01

package com.coherentsolutions.advanced.java.section01;

import java.util.concurrent.CompletableFuture;

/**
 * This class demonstrates a basic use of CompletableFuture for asynchronous computation.
 */
public class Ex02CompletableFutureBasic {

    public static void main(String[] args) {
        // Create a CompletableFuture that runs a task asynchronously
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Running an asynchronous task...");
            try {
                Thread.sleep(2000); // Simulate a long-running task
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Task completed!");
        });

        // Doing other work while the task is running
        System.out.println("Doing other work in the main thread...");

        // The future completes after the task is done
        future.join(); // Block and wait for the task to complete
        System.out.println("Main thread finished.");
    }
}
