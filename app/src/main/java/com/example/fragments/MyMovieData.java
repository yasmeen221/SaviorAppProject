package com.example.fragments;

public class MyMovieData {

    private String movieName;
    private String movieDate;
    private Integer movieImage;
    private String Button;


    public MyMovieData(String movieName, String movieDate, Integer movieImage) {
        this.movieName = movieName;
        this.movieDate = movieDate;
        this.movieImage = movieImage;
        this.Button=Button;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public Integer getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(Integer movieImage) {
        this.movieImage = movieImage;
    }

    public String getButton() {
        return Button;
    }

    public void setButton(String button) {
        Button = button;
    }
}
