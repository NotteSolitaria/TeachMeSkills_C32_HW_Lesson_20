package com.teachmeskills.lesson_20.task_1;

import com.teachmeskills.lesson_20.task_1.threads.MorningRunnable;
import com.teachmeskills.lesson_20.task_1.threads.MorningThread;

import java.util.Scanner;

/**
 * Create a program that simulates the morning: reading the news, tomorrow, coffee.
 * Set each thread a name and priority from the config file.
 * Let there be 3 threads.
 * Create and run 3 threads.
 * Make two options: using the Runnable interface and/or using the Thread class.
 */

public class ApplicationRunner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select the required method (1 - method using Thread, 2 - method using Runnable) :");
        int methodChoice = scanner.nextInt();

        if (methodChoice == 1) {

            MorningThread morningThread1 = new MorningThread("Read news");
            MorningThread morningThread2 = new MorningThread("Eat breakfast");
            MorningThread morningThread3 = new MorningThread("Drink coffee");

            morningThread1.setPriority(Thread.MAX_PRIORITY);
            morningThread2.setPriority(Thread.NORM_PRIORITY);
            morningThread3.setPriority(Thread.MIN_PRIORITY);

            try {
                morningThread1.join();
                morningThread2.join();
                morningThread3.join();

                System.out.println("All tasks were finished.");
            } catch (InterruptedException e) {
                System.err.println("Threads interrupted: " + e.getMessage());
            }

            scanner.close();

        } else if (methodChoice == 2) {
            MorningRunnable morningRunnable1 = new MorningRunnable("Eat breakfast");
            MorningRunnable morningRunnable2 = new MorningRunnable("Read news");
            MorningRunnable morningRunnable3 = new MorningRunnable("Drink coffee");

            morningRunnable1.run();
            morningRunnable2.run();
            morningRunnable3.run();

            scanner.close();

        } else {
            throw new RuntimeException("Invalid method choice.");
        }
    }
}
