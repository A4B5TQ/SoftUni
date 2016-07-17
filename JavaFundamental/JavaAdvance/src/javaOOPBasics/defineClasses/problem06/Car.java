package javaOOPBasics.defineClasses.problem06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Engine {
    Integer speed;
    Integer power;

    public Engine(Integer speed, Integer power) {
        this.power = power;
        this.speed = speed;
    }
}

class Tire {
    Double pressure;
    Integer age;

    public Tire(Double pressure, Integer age) {
        this.age = age;
        this.pressure = pressure;
    }
}

class Cargo {
    Integer weight;
    String type;

    public Cargo(Integer weight, String type) {
        this.type = type;
        this.weight = weight;
    }
}

public class Car {
    String model;
    Engine engine;
    Cargo cargo;
    Tire tire1;
    Tire tire2;
    Tire tire3;
    Tire tire4;

    public Car(String model,
               Integer engineSpeed,
               Integer enginePower,
               Integer cargoWeight,
               String cargoType,
               Double tire1Pressure,
               Integer tire1Age,
               Double tire2Pressure,
               Integer tire2Age,
               Double tire3Pressure,
               Integer tire3Age,
               Double tire4Pressure,
               Integer tire4Age) {

        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tire1 = new Tire(tire1Pressure, tire1Age);
        this.tire2 = new Tire(tire2Pressure, tire2Age);
        this.tire3 = new Tire(tire3Pressure, tire3Age);
        this.tire4 = new Tire(tire4Pressure, tire4Age);
    }


    void commands(String command) {
        switch (command) {
            case "fragile":
                boolean hasTirePressureUnderOne =
                        tire1.pressure < 1 ||
                                tire2.pressure < 1 ||
                                tire3.pressure < 1 ||
                                tire4.pressure < 1;

                if (cargo.type.equals(command) && hasTirePressureUnderOne) {
                    System.out.println(model);
                }
                break;
            case "flamable":
                if (cargo.type.equals(command) && engine.power > 250) {
                    System.out.println(model);
                }
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int dataCount = Integer.parseInt(sc.readLine());

        LinkedList<Car> cars = new LinkedList<>();

        for (int i = 0; i < dataCount; i++) {
           String[] carsInfo = sc.readLine().split("\\s+");
            String model =carsInfo[0];
            Integer engineSpeed = Integer.parseInt(carsInfo[1]);
            Integer enginePower = Integer.parseInt(carsInfo[2]);
            Integer cargoWeight = Integer.parseInt(carsInfo[3]);
            String cargoType = carsInfo[4];
            Double tire1Pressure = Double.parseDouble(carsInfo[5]);
            Integer tire1Age = Integer.parseInt(carsInfo[6]);
            Double tire2Pressure = Double.parseDouble(carsInfo[7]);
            Integer tire2Age = Integer.parseInt(carsInfo[8]);
            Double tire3Pressure = Double.parseDouble(carsInfo[9]);
            Integer tire3Age = Integer.parseInt(carsInfo[10]);
            Double tire4Pressure = Double.parseDouble(carsInfo[11]);
            Integer tire4Age = Integer.parseInt(carsInfo[12]);

            Car car = new Car(model,
                    engineSpeed,
                    enginePower,
                    cargoWeight,
                    cargoType,
                    tire1Pressure,
                    tire1Age,
                    tire2Pressure,
                    tire2Age,
                    tire3Pressure,
                    tire3Age,
                    tire4Pressure,
                    tire4Age);

            cars.add(car);
        }

        String command = sc.readLine();

        cars.stream().forEach(c -> c.commands(command));
    }
}
