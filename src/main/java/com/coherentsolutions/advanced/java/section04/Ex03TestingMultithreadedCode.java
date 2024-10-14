// File: Ex03TestingMultithreadedCode.java
// Package: com.coherentsolutions.advanced.java.section04

package com.coherentsolutions.advanced.java.section04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class demonstrates how to test multithreaded code using ExecutorService.
 */
public class Ex03TestingMultithreadedCode {

    public static void main(String[] args) {
        Ex01ThreadSafeClass account = new Ex01ThreadSafeClass(1000);

        // Using ExecutorService to simulate multiple threads depositing and withdrawing
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Simulate deposits
        for (int i = 0; i < 3; i++) {
            executor.submit(() -> {
                account.deposit(100);
                System.out.println("Deposited 100, Balance: " + account.getBalance());
            });
        }

        executor.shutdown();
    }
}

// Summary
// --------------------
// - Design thread-safe classes by following key principles such as minimizing shared mutability and using synchronization appropriately.
// - Balance concurrency and resource utilization to avoid performance issues like thread contention and overhead.
// - Use tools like `ExecutorService`, stress testing, and frameworks like JCStress to effectively test multithreaded code.

// Up Next: We’ll dive into more advanced concurrency utilities and patterns to build highly scalable applications!
