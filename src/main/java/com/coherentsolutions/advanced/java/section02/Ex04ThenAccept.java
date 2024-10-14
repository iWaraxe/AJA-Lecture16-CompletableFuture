// File: Ex04ThenAccept.java
// Package: com.coherentsolutions.advanced.java.section02

package com.coherentsolutions.advanced.java.section02;

import java.util.concurrent.CompletableFuture;

/**
 * This class demonstrates how to consume results using thenAccept().
 */
public class Ex04ThenAccept {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Hello CompletableFuture")
                .thenAccept(result -> System.out.println("Consumed result: " + result)); // Consumes result
    }
}
