package com.example.moveifacts.Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileReader {

    File moveis = new File("resources/imdb-data.csv");
    Scanner sc;

    {
        try {
            sc = new Scanner(moveis);
        } catch (FileNotFoundException e) {
            System.out.println("Fille could not be found");
            e.printStackTrace();
        }
    }

    public String getFirst() throws IOException {
        String line = Files.readAllLines(Paths.get(String.valueOf(moveis))).get(1);
        String[] stringAsArray = line.split(";");
        return stringAsArray[2];
    }

    public String getRandomMovie() throws IOException {
        Random r = new Random();
        int randomNumber = r.nextInt(1575) + 1;
        String line = Files.readAllLines(Paths.get(String.valueOf(moveis))).get(randomNumber);
        String[] stringAsArray = line.split(";");
        return stringAsArray[2];
    }

    public ArrayList<Movie> getTenSortByPopularity() throws IOException {
        Random r = new Random();
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int randomNumber = r.nextInt(1575) + 1;
            String line = Files.readAllLines(Paths.get(String.valueOf(moveis))).get(randomNumber);
            String[] stringAsArray = line.split(";");
            int year = Integer.parseInt(stringAsArray[0]);
            int length = Integer.parseInt(stringAsArray[1]);
            int popularity = Integer.parseInt(stringAsArray[4]);
            Movie m = new Movie(year,length,stringAsArray[2],stringAsArray[3],popularity,stringAsArray[5]);
            movies.add(m);
        }
        Collections.sort(movies, Collections.reverseOrder());
        return movies;
    }

    public void CountWords(Map< String, Integer> words) throws FileNotFoundException
    {
        String word;
        Scanner file=new Scanner (new File("resources/imdb-data.csv"));
        while(file.hasNext()){
            word=file.next().toLowerCase();
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
