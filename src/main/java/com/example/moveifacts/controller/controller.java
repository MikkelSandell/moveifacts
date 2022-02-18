package com.example.moveifacts.controller;


import com.example.moveifacts.Services.FileReader;
import com.example.moveifacts.Services.Gretting;
import com.example.moveifacts.Services.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies = f.getTenSortByPopularity();
        return movies.toString();
    }

    @GetMapping("/howManyWonAnAward")
    public int howManyWonAnAward() throws FileNotFoundException {
        HashMap<String,Integer> text = new HashMap<>();
        CountWords(text);
        int award = text.get("Yes");
        return award;
    }
    void CountWords(Map< String, Integer> words) throws FileNotFoundException
    {
        String word;
        Scanner file=new Scanner (new File("resources/imdb-data.csv"));
        while(file.hasNext()){
            word=file.next().toLowerCase();
            if (word.lastIndexOf("s") == word.length() - 1) {
                word = word.substring(0, word.length() - 1);
            } else if (word.endsWith("'s")) {
                word = word.substring(0, word.length() - 2);
            }else if (word.endsWith("!")||word.endsWith("?")||word.endsWith("\"")||word.endsWith(".")||word.endsWith(",")||word.endsWith(";")){
                word = word.substring(0, word.length() - 1);
            }
            Integer count=words.get(word);
            if(count!=null)
                count++;
            else
                count=1;
            words.put(word,count);
        }
        file.close();
    }
}
