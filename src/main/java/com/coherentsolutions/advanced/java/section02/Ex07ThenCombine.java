// File: Ex07ThenCombine.java
// Package: com.coherentsolutions.advanced.java.section02

package com.coherentsolutions.advanced.java.section02;

import java.util.concurrent.CompletableFuture;

/**
 * This class demonstrates how to combine two independent futures using thenCombine().
 */
public class Ex07ThenCombine {

    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> " World");

        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, String::concat);

        System.out.println(combinedFuture.join()); // Prints: Hello World
    }
}
