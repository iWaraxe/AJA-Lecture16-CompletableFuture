// File: Ex02CustomExecutor.java
// Package: com.coherentsolutions.advanced.java.section02

package com.coherentsolutions.advanced.java.section02;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class demonstrates how to use custom executors with CompletableFuture.
 */
public class Ex02CustomExecutor {

    public static void main(String[] args) {
        // Create a custom executor
        ExecutorService customExecutor = Executors.newFixedThreadPool(2);

        // Using custom executor with supplyAsync()
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Running task with custom executor");
            return "Task result";
        }, customExecutor);

        System.out.println(future.join()); // Get result

        // Shutdown the executor
        customExecutor.shutdown();
    }
}
