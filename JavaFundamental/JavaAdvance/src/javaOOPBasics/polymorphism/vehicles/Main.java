package javaOOPBasics.polymorphism.vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] inputData = sc.readLine().split("\\s+");
        double fuelQuntity = Double.parseDouble(inputData[1]);
        double fuelConsumpting = Double.parseDouble(inputData[2]);
        Vehicle car = null /*new Car(fuelQuntity, fuelConsumpting)*/;
        inputData = sc.readLine().split("\\s+");
        fuelQuntity = Double.parseDouble(inputData[1]);
        fuelConsumpting = Double.parseDouble(inputData[2]);
        Vehicle truck = new Truck(fuelQuntity, fuelConsumpting);

        int commandsCount = Integer.parseInt(sc.readLine());

        for (int i = 0; i < commandsCount; i++) {
            String[] commands = sc.readLine().split("\\s+");

            switch (commands[0].toLowerCase()) {
                case "drive":
                    double distance = Double.parseDouble(commands[2]);
                    switch (commands[1].toLowerCase()) {
                        case "car":
                            try {
                                car.drive(distance);
                                System.out.printf("Car travelled %s km%n",
                                        new DecimalFormat("0.######").format(distance));
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                            }
                            break;
                        case "truck":
                            try {
                                truck.drive(distance);
                                System.out.printf("Truck travelled %s km%n",
                                        new DecimalFormat("0.######").format(distance));
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                            }
                            break;
                    }
                    break;
                case "refuel":
                    double fuel = Double.parseDouble(commands[2]);
                    switch (commands[1].toLowerCase()) {
                        case "car":
                            try {
                                car.refueled(fuel);
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                            }
                            break;
                        case "truck":
                            try {
                                truck.refueled(fuel);
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                            }
                            break;
                    }
                    break;
            }

        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
