package com.SDD.web.controller.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//doar pe clase cu @controller poti mapa
@ResponseBody //raspunsul din metoda sa-l punem in body-ul paginiii
//combinatie intre @controller si @Responsebody == @RestController
@RequestMapping("person") //stie sa combine person cu /name , /cnp , /address
public class PersonController {

    @GetMapping("{id}/name") //placeholder nu stim ce id o sa fie ==>  person/{id}/name

    public String showName(@PathVariable("id") int personId){ //cand e adnotata, stie sa mapeze personId la {id}
        return " car "+ personId; //return car, o sa fie in body-ul paginii noastre

        //person/{id}/name
        //person/5/name
    }

    @GetMapping("cnp")
    public int showCNP(){
        return 1222;
    }

    @GetMapping("address")
    public String showAddress(){
        return "Closca";
    }

    @GetMapping("zip")
    public int showZipCode(){
        return 10;
    }
}
