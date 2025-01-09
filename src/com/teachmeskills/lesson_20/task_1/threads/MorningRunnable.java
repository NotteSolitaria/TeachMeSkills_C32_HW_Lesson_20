package com.teachmeskills.lesson_20.task_1.threads;

public class MorningRunnable implements Runnable {
    String threadName;
    Thread thread;

    public MorningRunnable(String threadName) {
        this.threadName = threadName;
        thread = new Thread(this.threadName);
        thread.start();
    }

    public void run() {
        try {
            System.out.println("Next task was started: " + threadName);
        } catch (Exception e) {
            throw new RuntimeException("Error in thread " + threadName, e);
        }
    }
}
