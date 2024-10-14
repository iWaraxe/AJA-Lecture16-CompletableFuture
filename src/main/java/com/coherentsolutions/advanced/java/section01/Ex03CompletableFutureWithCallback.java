// File: Ex03CompletableFutureWithCallback.java
// Package: com.coherentsolutions.advanced.java.section01

package com.coherentsolutions.advanced.java.section01;

import java.util.concurrent.CompletableFuture;

/**
 * This class demonstrates how to use callbacks in CompletableFuture.
 */
public class Ex03CompletableFutureWithCallback {

    public static void main(String[] args) {
        // Create a CompletableFuture that runs a task and triggers a callback when done
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Running an asynchronous task...");
            try {
                Thread.sleep(2000); // Simulate a long-running task
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Task completed!");
        }).thenRun(() -> {
            // This callback is triggered when the task completes
            System.out.println("Callback: Task completed successfully.");
        });

        // Main thread continues doing other work
        System.out.println("Doing other work in the main thread...");

        // Block and wait for all tasks to complete
        future.join();
        System.out.println("Main thread finished.");
    }
}

// Summary
// --------------------
// - The `Future` interface, while useful, has limitations due to its blocking nature and difficulty in composing tasks.
// - `CompletableFuture` was introduced in Java 8 to provide a more powerful and flexible way to handle asynchronous tasks.
// - With `CompletableFuture`, we can run non-blocking tasks, compose multiple tasks, and handle asynchronous computation more elegantly.

// Up Next: We’ll dive deeper into the various features of `CompletableFuture`, such as task composition, exception handling, and combining multiple asynchronous tasks.
