package com.SDD.web.service.car;

public class Car {

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "car{" +
                "name='" + name + '\'' +
                '}';
    }
}
