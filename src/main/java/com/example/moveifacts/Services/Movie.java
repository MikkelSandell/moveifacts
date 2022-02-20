package com.example.moveifacts.Services;

import java.util.ArrayList;
import java.util.Comparator;

public class Movie implements Comparable<Movie> {
    private int year;
    private int length;
    private String title;
    private String subject;
    private  int popularity;
    private  String awards;

    public Movie (int year, int length, String title, String subject, int popularity, String awards){
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;
    }

    public int getYear() {
        return year;
    }

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getAwards() {
        return awards;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    @Override
    public int compareTo(Movie o) {
        Integer o1 = this.popularity;
        return o1.compareTo(o.getPopularity());
    }

    @Override
    public String toString() {
        return ("Title: " + title + " Year: " + year + " Length: " + length + " Subject: " + subject +
                " Popularity: "+ popularity + " Awards: " + awards);

    }
}
