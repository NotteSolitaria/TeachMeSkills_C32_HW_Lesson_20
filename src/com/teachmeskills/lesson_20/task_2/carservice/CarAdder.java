package com.teachmeskills.lesson_20.task_2.carservice;


public class CarAdder implements Runnable {
    private final ServiceStation serviceStation;
    private int carCount = 0;

    public CarAdder(ServiceStation serviceStation) {
        this.serviceStation = serviceStation;
    }

    @Override
    public void run() {
        while (true) {
            try {

                serviceStation.addCar("Car-" + carCount);
                carCount++;

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
