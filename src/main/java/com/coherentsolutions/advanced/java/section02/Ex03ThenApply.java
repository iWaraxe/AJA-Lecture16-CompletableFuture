// File: Ex03ThenApply.java
// Package: com.coherentsolutions.advanced.java.section02

package com.coherentsolutions.advanced.java.section02;

import java.util.concurrent.CompletableFuture;

/**
 * This class demonstrates how to chain CompletableFutures with thenApply() to transform results.
 */
public class Ex03ThenApply {

    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(result -> result + " World") // Transform result
                .thenApply(s -> s.toUpperCase()); // Transform again

        System.out.println("Doing something in the main thread");
        System.out.println(future.join()); // Prints: HELLO WORLD
    }
}
