// File: Ex08AllOfAnyOf.java
// Package: com.coherentsolutions.advanced.java.section02

package com.coherentsolutions.advanced.java.section02;

import java.util.concurrent.CompletableFuture;

/**
 * This class demonstrates the use of allOf() and anyOf() for handling multiple futures.
 */
public class Ex08AllOfAnyOf {

    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Task 1");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Task 2");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Task 3");

        // allOf(): Complete when all tasks are done
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2, future3);
        allOf.join();
        System.out.println("All tasks completed");

        // anyOf(): Complete when any one task is done
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(future1, future2, future3);
        System.out.println("First completed task: " + anyOf.join());
    }
}
