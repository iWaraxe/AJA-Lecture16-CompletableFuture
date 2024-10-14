// File: Ex05ThenRun.java
// Package: com.coherentsolutions.advanced.java.section02

package com.coherentsolutions.advanced.java.section02;

import java.util.concurrent.CompletableFuture;

/**
 * This class demonstrates the use of thenRun() to trigger an action when a task completes.
 */
public class Ex05ThenRun {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Task complete")
                .thenRun(() -> System.out.println("Running after task completes")); // Runs after completion
    }
}
