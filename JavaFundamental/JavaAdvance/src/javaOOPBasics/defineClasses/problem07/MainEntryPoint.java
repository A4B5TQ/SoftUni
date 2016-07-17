package javaOOPBasics.defineClasses.problem07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;


class Car {
    private static final Integer WEIGHT_DEFFAULT = 0;
    private static final String COLOR_DEFFAULT = "";
    private String model;
    private Engine engine;
    private Integer weight;
    private String color;

    public Car(String model, Engine engine, Integer weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this(model, engine, WEIGHT_DEFFAULT, COLOR_DEFFAULT);

    }

    public Car(String model, Engine engine, Integer weight) {
        this(model, engine, weight, COLOR_DEFFAULT);

    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, WEIGHT_DEFFAULT, color);

    }

    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();
        out.append(this.model + ":" + System.lineSeparator());
        out.append("  " + this.engine.toString() + System.lineSeparator());
        if (this.weight != WEIGHT_DEFFAULT){
            out.append("  Weight: " + this.weight + System.lineSeparator());
        } else {
            out.append("  Weight: n/a" + System.lineSeparator());
        }

        if (!this.color.isEmpty()){
            out.append("  Color: " + this.color + System.lineSeparator());
        } else {
            out.append("  Color: n/a" + System.lineSeparator());
        }
        return out.toString().trim();
    }
}

class Engine {
    private static final Integer DISPLACEMENT_DEFFAULT = 0;
    private static final String EFFICIENCY_DEFFAULT = "";

    private String model;
    private Integer power;
    private Integer displacement;
    private String efficiency;

    public Engine(String model, Integer power, Integer displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, Integer power) {
        this(model, power, DISPLACEMENT_DEFFAULT, EFFICIENCY_DEFFAULT);
    }

    public Engine(String model, Integer power, Integer displacement) {
        this(model, power, displacement, EFFICIENCY_DEFFAULT);
    }

    public Engine(String model, Integer power, String efficiency) {
        this(model, power, DISPLACEMENT_DEFFAULT, efficiency);
    }

    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();

        out.append(this.model + ":" + System.lineSeparator());
        out.append("    Power: " + this.power + System.lineSeparator());
        if (this.displacement != DISPLACEMENT_DEFFAULT){
            out.append("    Displacement: " + this.displacement + System.lineSeparator());
        } else {
            out.append("    Displacement: " + "n/a" + System.lineSeparator());
        }

        if (!this.efficiency.isEmpty()){
            out.append("    Efficiency: " + this.efficiency + System.lineSeparator());
        } else {
            out.append("    Efficiency: " + "n/a" + System.lineSeparator());
        }

        return out.toString().trim();
    }
}

public class MainEntryPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int engineCount = Integer.parseInt(sc.readLine());

        HashMap<String, Engine> engines = new HashMap<>();
        LinkedList<Car> cars = new LinkedList<>();

        for (int i = 0; i < engineCount; i++) {
            String[] engineInfo = sc.readLine().split("\\s+");

            String model = engineInfo[0];
            Integer power = Integer.parseInt(engineInfo[1]);

            Engine engine = new Engine(model,power);

            if (engineInfo.length > 3){
                Integer displacement = Integer.parseInt(engineInfo[2]);
                String color = engineInfo[3];
                engine = new Engine(model,power,displacement,color);
            } else  if(engineInfo.length > 2) {
                try {
                    Integer displacement = Integer.parseInt(engineInfo[2]);
                    engine = new Engine(model,power,displacement);
                } catch (NumberFormatException ex){
                    String color = engineInfo[2];
                    engine = new Engine(model,power,color);
                }
            }
            engines.put(model,engine);
        }

        int carsCount = Integer.parseInt(sc.readLine());

        for (int i = 0; i < carsCount; i++) {
           String[] carsInfo = sc.readLine().split("\\s+");

            String model = carsInfo[0];
            Engine engine = engines.get(carsInfo[1]);

            Car car = null;

            switch (carsInfo.length){

                case 2: car = new Car(model,engine);
                    break;
                case 3:
                    try {
                        Integer weight = Integer.parseInt(carsInfo[2]);
                        car = new Car(model, engine, weight);
                    } catch (NumberFormatException ex){
                        String efficiency = carsInfo[2];
                        car = new Car(model,engine,efficiency);
                    }
                    break;
                case 4:
                    Integer weight = Integer.parseInt(carsInfo[2]);
                    String color = carsInfo[3];
                    car = new Car(model,engine,weight,color);
                    break;
            }
            cars.add(car);
        }

        cars.stream().forEach(System.out::println);
    }
}
