# ThreadSafe Java Program

This Java program demonstrates the concept of thread safety using the `synchronized` keyword. In a multi-threaded environment, when multiple threads access shared resources concurrently, it can lead to data inconsistency or loss if not properly synchronized. The `synchronized` keyword ensures that only one thread can access the synchronized method or block at a time, preventing data corruption or race conditions.

## Program Overview

The `ThreadSafe` class contains a shared variable `count` which is incremented by multiple threads concurrently. To ensure thread safety, the `increase()` method is declared as synchronized, allowing only one thread to execute it at a time.

Two threads are created to concurrently increment the `count` variable in the `runThreaders()` method. Each thread runs a loop to increment `count` 5000 times.

After starting both threads, the main thread waits for them to finish using the `join()` method, ensuring that the final value of `count` is printed only after both threads have completed their execution.

## How Synchronization Works

- When a thread enters the `increase()` method, it acquires the intrinsic lock associated with the object (`ThreadSafe` instance in this case).
- Once a thread acquires the lock, it can execute the synchronized method. Other threads attempting to execute synchronized methods on the same object will be blocked until the lock is released.
- After completing the execution of the synchronized method, the lock is released, allowing other threads to acquire it and execute the synchronized method.

## Usage

To run the program:

1. Compile the `ThreadSafe.java` file: `javac ThreadSafe.java`
2. Run the compiled program: `java ThreadSafe`

## Output

The program will output the final value of `count` after both threads have finished executing. Since the `increase()` method is synchronized, the final value of `count` will always be the sum of increments from both threads, preventing any data loss or inconsistency.
