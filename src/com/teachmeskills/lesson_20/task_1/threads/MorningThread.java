package com.teachmeskills.lesson_20.task_1.threads;

public class MorningThread extends Thread {
    String threadName;

    public MorningThread(String threadName) {
        this.threadName = threadName;
        this.start();
    }

    @Override
    public void run() {
        try {
            System.out.println("Next task was started: " + threadName);
        } catch (Exception e) {
            throw new RuntimeException("Error in thread " + threadName, e);
        }
    }
}
