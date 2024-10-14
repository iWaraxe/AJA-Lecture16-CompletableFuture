// File: Ex06ThenCompose.java
// Package: com.coherentsolutions.advanced.java.section02

package com.coherentsolutions.advanced.java.section02;

import java.util.concurrent.CompletableFuture;

/**
 * This class demonstrates how to combine dependent tasks using thenCompose().
 */
public class Ex06ThenCompose {

    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> result + " World"));

        System.out.println(future.join()); // Prints: Hello World
    }
}
