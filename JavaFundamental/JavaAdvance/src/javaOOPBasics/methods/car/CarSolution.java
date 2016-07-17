package javaOOPBasics.methods.car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Car {
    private final Double START_DISTANCE = 0D;
    private Integer speed;
    private Integer fuel;
    private Integer fuelEconomy;
    private Double distance;

    public Car(Integer speed, Integer fuel, Integer fuelEconomy) {
        this.speed = speed;
        this.fuel = fuel;
        this.fuelEconomy = fuelEconomy;
        this.distance = START_DISTANCE;
    }

    public void travel(Integer distance) {
        Integer fuelCost = ((distance / 100) * this.fuelEconomy);
        if (fuelCost <= this.fuel){
            this.distance += distance;
            this.fuel -= fuelCost;
        } else {
            this.distance += (this.fuel / this.fuelEconomy) * 100;
            this.fuel = 0;
        }
    }

    public void refuel(Integer fuel) {
        this.fuel += fuel;
    }

    public void getTraveledDistance() {
        System.out.printf("Total distance: %.1f kilometers%n", this.distance);
    }

    public void time() {

        double time = this.distance / this.speed;
        int hours = (int) time;
        int minutes = (int)((time - hours) * 60);
        System.out.printf("Total time: %d hours and %d minutes%n", hours,minutes);
    }

    public void getFuel(){
        System.out.printf("Fuel left: %.1f liters%n",(double)this.fuel);
    }
}

public class CarSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Integer[] carData = Arrays.stream(sc.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Car car = new Car(carData[0],carData[1],carData[2]);

        String input = sc.readLine();

        while (!input.endsWith("END")){
            String[] data = input.split("\\s+");

            switch (data[0]){
                case "Travel": car.travel(Integer.parseInt(data[1]));
                    break;
                case "Refuel": car.refuel(Integer.parseInt(data[1]));
                    break;
                case "Distance": car.getTraveledDistance();
                    break;
                case "Time": car.time();
                    break;
                case "Fuel": car.getFuel();
                    break;
            }
            input = sc.readLine();
        }
    }
}
