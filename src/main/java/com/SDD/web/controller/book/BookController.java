package com.SDD.web.controller.book;

import org.springframework.web.bind.annotation.*;

//si controllerele sunt niste bean-uri
//trb adnotate cu @RestController
//pot avea si ele dependency injection
//cand vede @Controller stie ca vorbim despre un context web
//deobicei gasteste adnotarile @GetMapping

@RestController
@RequestMapping("book")
public class BookController {

    @GetMapping("search/{author}/genre/{genre}")
    public String doSearch(@PathVariable("author")String author,
                           @PathVariable("genre")String genre){
        return "Searching for books from author "+ author + " and genre "+ genre;

    }
    //daca primesti un @GetMapping, apeleaza metoda searchByIdandName

    @GetMapping("{id}/name/{name}")
    public String searchByIdandName(@PathVariable("id")int id,
                                    @PathVariable("name") String name){
        return "Name of the book is  " + name +", id of the book is: " +id;

    }

    @GetMapping("genre/{genre}")
    public String doList(@PathVariable("genre") String genre,
                         @RequestParam("page") int page,
                         @RequestParam(value = "limit",required = false) int limit){ //daca nu este valoare, nu crapa
        return String.format("Listing '%d' books with genre '%s' from page '%d'",limit,genre,page);

        //http://localhost:9000/book/genre/drama?page=1&limit=20
        //get params from URL
        //afiseaza valorile din url in body-ul paginii
    }

    @PostMapping("save")
    //putem lua parametri si din post, am creat in postman 2 params, putem lua si dintr-un fisier html
    public void postSave(@RequestParam("author")String author,
                     @RequestParam("title") String title){
        System.out.println("Calling save for "+author+" and "+title);

        //afiseaza valorile din postman in terminal

    }
    //@RequestMapping(method= RequestMethod.GET, path"save")
    //echivalentul old a lui @GetMapping
    @GetMapping("save") //pe acelasi URL putem avea mai multe tipuri de request (post, get)
    public String getSave(){
        return " save works better with post ";
    }
}
