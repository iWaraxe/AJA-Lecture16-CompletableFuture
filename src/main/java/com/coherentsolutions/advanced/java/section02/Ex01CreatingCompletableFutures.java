// File: Ex01CreatingCompletableFutures.java
// Package: com.coherentsolutions.advanced.java.section02

package com.coherentsolutions.advanced.java.section02;

import java.util.concurrent.CompletableFuture;

/**
 * This class demonstrates how to create CompletableFuture using runAsync() and supplyAsync().
 */
public class Ex01CreatingCompletableFutures {

    public static void main(String[] args) {
        // Using runAsync() - No result is returned
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("Running task with runAsync()");
            try {
                Thread.sleep(1000); // Simulate task delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Using supplyAsync() - Returns a result
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Running task with supplyAsync()");
            try {
                Thread.sleep(1000); // Simulate task delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result from supplyAsync";
        });

        // Waiting for the completion of tasks
        future1.join();
        //String join = future2.join();
        System.out.println(future2.join()); // Print the result
    }
}
