// File: Ex09Exceptionally.java
// Package: com.coherentsolutions.advanced.java.section02

package com.coherentsolutions.advanced.java.section02;

import java.util.concurrent.CompletableFuture;

/**
 * This class demonstrates how to handle exceptions in a pipeline using exceptionally().
 */
public class Ex09Exceptionally {

    public static void main(String[] args) {
        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Something went wrong!");
        }).exceptionally(ex -> {
            System.out.println("Exception occurred: " + ex.getMessage());
            return "Fallback result";
        });

        System.out.println(future.join()); // Prints: Fallback result
    }
}
