package org.example;

public class Car {
    String color;
    String brand;

    public Car() {
    }

    public Car(String color, String brand) {
        this.brand = brand;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }
}
