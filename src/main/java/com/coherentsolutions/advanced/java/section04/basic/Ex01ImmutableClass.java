// File: Ex01ImmutableClass.java
// Package: com.coherentsolutions.advanced.java.section04

package com.coherentsolutions.advanced.java.section04.basic;

/**
 * A simple immutable class that is inherently thread-safe.
 */
public final class Ex01ImmutableClass {

    private final String name;
    private final int age;

    public Ex01ImmutableClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// Each thread operates on its own local variables, so no synchronization is required.
