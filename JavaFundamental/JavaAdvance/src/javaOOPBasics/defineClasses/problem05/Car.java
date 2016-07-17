package javaOOPBasics.defineClasses.problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Car {

    String model;
    Double fuelAmount;
    Double fuelCost;
    Double distance;

    public Car(String model, Double fuelAmount, Double fuelCost, Double distance) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distance = distance;
    }

    public Car(String model, Double fuelAmount, Double fuelCost) {
        this(model, fuelAmount, fuelCost, 0D);
    }

    void drive(Double amountOfKilometers) {
        if (amountOfKilometers * fuelCost > this.fuelAmount) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            fuelAmount -= amountOfKilometers * fuelCost;
            distance += amountOfKilometers;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int carsCount = Integer.parseInt(sc.readLine());

        HashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < carsCount; i++) {

            String[] carInfo = sc.readLine().split("\\s+");
            String model = carInfo[0];
            Double fuel = Double.parseDouble(carInfo[1]);
            Double fuelPerKilometers = Double.parseDouble(carInfo[2]);

            Car car = new Car(model, fuel, fuelPerKilometers);
            cars.put(model, car);
        }

        String driveCars = sc.readLine();

        while (!driveCars.equals("End")) {

            String[] inputCommands = driveCars.split("\\s+");
            String carToDrive = inputCommands[1];
            Double distanceToDrive = Double.parseDouble(inputCommands[2]);

            cars.get(carToDrive).drive(distanceToDrive);
            driveCars = sc.readLine();
        }

        cars.entrySet().stream().forEach(c -> {
            Car car = c.getValue();
            System.out.printf("%s %.2f %.0f%n",car.model,car.fuelAmount,car.distance);
        });
    }
}
