// File: Ex01BlockingFuture.java
// Package: com.coherentsolutions.advanced.java.section01

package com.coherentsolutions.advanced.java.section01;

import java.util.concurrent.*;

/**
 * This class demonstrates the blocking nature of Future.get().
 */
public class Ex01BlockingFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit a long-running task
        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000); // Simulate long-running task
            return "Task Completed!";
        });

        // Doing some other work while waiting for the task to complete
        System.out.println("Doing other work in main thread...");

        // Block until the task completes and retrieve the result
        String result = future.get();  // Blocks here until the task completes
        System.out.println("Result from Future: " + result);

        executor.shutdown();
    }
}
