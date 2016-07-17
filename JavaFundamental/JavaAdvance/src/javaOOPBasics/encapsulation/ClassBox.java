package javaOOPBasics.encapsulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

class Box {
    private Double length;

    private Double width;
    private Double height;

    public Box(Double length, Double width, Double height) throws Exception {
        setWidth(width);
        setLength(length);
        setHeight(height);

    }

    public double getSurfaceArea() {
        return (2 * this.length * this.width)
                + (2 * this.length * this.height)
                + (2 * this.width * this.height);
    }

    public double getLateralSurfaceArea() {
        return (2 * this.length * this.height)
                + (2 * this.width * this.height);
    }

    public double getVolume() {
        return this.length
                * this.height
                * this.width;
    }

    public void setHeight(Double height) throws Exception {
        if (height > 0) {
            this.height = height;
        } else {
            throw new Exception("Height cannot be zero or negative.");
        }
    }

    public void setLength(Double length) throws Exception {

        if (length > 0) {

            this.length = length;
        } else {
            throw new Exception("Length cannot be zero or negative.");
        }
    }

    public void setWidth(Double width) throws Exception {

        if (width > 0) {
            this.width = width;
        } else {
            throw new Exception("Width cannot be zero or negative.");
        }
    }
}

public class ClassBox {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Double length = Double.parseDouble(sc.readLine());
        Double width = Double.parseDouble(sc.readLine());
        Double height = Double.parseDouble(sc.readLine());

        Class boxClass = Box.class;
        Field[] fields = boxClass.getDeclaredFields();
        System.out.println(Arrays.asList(fields)
                .stream()
                .filter(f -> Modifier.isPrivate(f.getModifiers())).count());

        try {
            Box box = new Box(length, width, height);

            System.out.printf("Surface Area - %.2f%n", box.getSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", box.getLateralSurfaceArea());
            System.out.printf("Volume - %.2f%n", box.getVolume());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
