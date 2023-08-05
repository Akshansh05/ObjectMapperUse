package org.example;

public class Car2 {
    String color;
    String brand;
    String type;

    public Car2() {
    }

    public Car2(String color, String brand, String type) {
        this.brand = brand;
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }
}
