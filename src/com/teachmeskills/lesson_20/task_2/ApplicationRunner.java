package com.teachmeskills.lesson_20.task_2;

import com.teachmeskills.lesson_20.task_2.carservice.CarAdder;
import com.teachmeskills.lesson_20.task_2.carservice.CarRemover;
import com.teachmeskills.lesson_20.task_2.carservice.ServiceStation;
import com.teachmeskills.lesson_20.task_2.constants.Constants;

/**
 * There is a service station. The service station can service a maximum of a certain number of cars.
 * Create a class that will be launched in a separate thread and will add cars for servicing to the service station.
 * Create a class that will be launched in a separate thread and will take repaired cars from the service station.
 * Let the maximum number of cars available for servicing be specified in the interface for storing constants.
 * Use synchronized, wait, notify.
 */

public class ApplicationRunner {
    public static void main(String[] args) {
        ServiceStation serviceStation = new ServiceStation(Constants.MAX_CARS);

        Thread adderThread = new Thread(new CarAdder(serviceStation));
        Thread removerThread = new Thread(new CarRemover(serviceStation));

        adderThread.start();
        removerThread.start();
    }
}
