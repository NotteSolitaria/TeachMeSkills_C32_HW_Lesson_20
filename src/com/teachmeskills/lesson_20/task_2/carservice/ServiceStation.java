package com.teachmeskills.lesson_20.task_2.carservice;

import java.util.ArrayList;
import java.util.List;

public class ServiceStation {
    private List<String> cars;
    private final int maxCars;

    public ServiceStation(int maxCars) {
        this.maxCars = maxCars;
        this.cars = new ArrayList<>();
    }

    public synchronized void addCar(String car) throws InterruptedException {
        while (cars.size() == maxCars) {
            System.out.println("Service station is full. Waiting...");
            wait();
        }

        cars.add(car);

        System.out.println("Added car: " + car);

        notify();
    }

    public synchronized String removeCar() throws InterruptedException {
        while (cars.isEmpty()) {
            System.out.println("No cars available. Waiting...");
            wait();
        }

        String car = cars.remove(0);

        System.out.println("Removed car: " + car);

        notify();

        return car;
    }
}
