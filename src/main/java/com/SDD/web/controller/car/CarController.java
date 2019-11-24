package com.SDD.web.controller.car;

import com.SDD.web.service.car.Car;
import com.SDD.web.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@RestController// combinatia intre @ResponseBody si @controller

@RequestMapping("car")
public class CarController {

    //controlleru trebuie sa stie de service
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) { //trb adnotarea @Component sau @Service la clasa CarService ca sa nu crape aici
        this.carService = carService;
    }

    @PostMapping("save")//cand cineva trimite un request post catre save
    //intra in metoda save

    public String save(@RequestParam("name")String carName){
        //bagam in lista creata in carService masina noastra
        Car car = new Car(carName);
        carService.add(car);//avem metoda add in carService

        return "Saved car "+ carName;//returnam masina salvata
    }

    @GetMapping("all")
    public String getAll(){
        List<Car> all = carService.findAll();
        //din lista all deschidem un flux cu stream

        //dintr o lista de masini, am facut o lista de stringuri de masini
        List<String> names = all.stream().map(Car::getName).collect(Collectors.toList());// :: ->method reference
        //1 deschis flux de date x(Car) ->y (String) map-u face conversii
        //2 din x convertim in y   --> conveertim un car la string  x=car  y=string
        //3 colectam noile date intr-o lista separata (in names)


        //lipeste stringuri
        StringJoiner joiner = new StringJoiner(",");
        names.forEach(joiner::add);//pt fiecare lista names, sa le concateneze cu virgula
        //puteam si cu
        // for(String name :names){
        //    joiner.add(name)
        //in loc de forEach

        return joiner.toString();
    }
}
