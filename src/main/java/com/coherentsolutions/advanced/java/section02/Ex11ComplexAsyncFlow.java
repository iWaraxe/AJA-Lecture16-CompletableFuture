// File: Ex11ComplexAsyncFlow.java
// Package: com.coherentsolutions.advanced.java.section02

package com.coherentsolutions.advanced.java.section02;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class demonstrates a complex asynchronous flow using CompletableFuture.
 */
public class Ex11ComplexAsyncFlow {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletableFuture<String> apiCall1 = CompletableFuture.supplyAsync(() -> {
            simulateAPICall("API 1", 2000);
            return "Result from API 1";
        }, executor);

        CompletableFuture<String> apiCall2 = CompletableFuture.supplyAsync(() -> {
            simulateAPICall("API 2", 1500);
            return "Result from API 2";
        }, executor);

        CompletableFuture<String> apiCall3 = CompletableFuture.supplyAsync(() -> {
            simulateAPICall("API 3", 1000);
            return "Result from API 3";
        }, executor);

        // Combine all API results
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(apiCall1, apiCall2, apiCall3)
                .thenRun(() -> System.out.println("All API calls completed"));

        // Handle results after all calls are done
        allTasks.thenRun(() -> {
            System.out.println(apiCall1.join());
            System.out.println(apiCall2.join());
            System.out.println(apiCall3.join());
        });

        allTasks.join(); // Ensure all tasks complete
        executor.shutdown();
    }

    private static void simulateAPICall(String apiName, int delay) {
        try {
            System.out.println(apiName + " started...");
            Thread.sleep(delay);
            System.out.println(apiName + " completed!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Summary
// --------------------
// - `CompletableFuture` provides powerful tools for creating, chaining, and combining asynchronous tasks.
// - Methods like `thenApply()`, `thenCompose()`, and `thenCombine()` allow you to build non-blocking, asynchronous pipelines.
// - Exception handling is simplified with `exceptionally()` and `handle()`.
// - Real-world scenarios often involve complex asynchronous flows, and `CompletableFuture` helps streamline those flows.

// Up Next: We’ll cover advanced CompletableFuture use cases, including timeouts and concurrency controls!
