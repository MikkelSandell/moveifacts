package com.example.moveifacts.controller;


import com.example.moveifacts.Services.FileReader;
import com.example.moveifacts.Services.Gretting;
import com.example.moveifacts.Services.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class controller {
    FileReader f = new FileReader();

    @GetMapping("/")
    public String Hallo(){
        Gretting g = new Gretting();
        return g.gretting();
    }

    @GetMapping("/getFirst")
    public String First() throws IOException {

        return "Title of first movie is: " +f.getFirst();
    }

    @GetMapping("/getRandom")
    public String RandomeMovie() throws IOException {
        return f.getRandomMovie();
    }

    @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPopularity() throws IOException {

        ArrayList<Movie> movies;
        movies = f.getTenSortByPopularity();

        return movies.toString();
        }


    @GetMapping("/howManyWonAnAward")
    public String howManyWonAnAward() throws NullPointerException, FileNotFoundException {

        return f.CountWords();
    }
}
