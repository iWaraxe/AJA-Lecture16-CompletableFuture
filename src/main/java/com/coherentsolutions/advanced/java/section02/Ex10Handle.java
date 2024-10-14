// File: Ex10HandleFixed.java
// Package: com.coherentsolutions.advanced.java.section02

package com.coherentsolutions.advanced.java.section02;

import java.util.concurrent.CompletableFuture;

/**
 * This class demonstrates how to handle both results and exceptions using handle().
 */
public class Ex10Handle {

    public static void main(String[] args) {
        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Something went wrong!");
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Exception: " + ex.getMessage());
                return "Handled exception"; // Return a valid String in case of exception
            } else {
                return result; // Otherwise, return the original result
            }
        });

        System.out.println(future.join()); // Prints: Handled exception
    }
}
