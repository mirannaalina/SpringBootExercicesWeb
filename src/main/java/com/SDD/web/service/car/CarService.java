package com.SDD.web.service.car;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final List<Car> cars =  new ArrayList<>();

    public void add(Car car){
        cars.add(car); //adauga in lista de masini
    }

    public List<Car> findAll(){
        return cars;
    }
}
