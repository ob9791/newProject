package com.tsi.o.blidi.program.Film;

import javax.persistence.*;

@Entity
@Table(name="film")

public class Film{

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="film_id")

    private int filmId;
    String title;
    String description;

    String rating;
    int length;
    int language_id;



    //Constructors

    public Film(String title, String description,String rating, int length, int language_id) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.length = length;
        this.language_id = language_id;
    }

    public Film(int filmId, String title, String description, String rating, int length, int language_id) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.length = length;
        this.language_id = language_id;
    }

    public Film(){}



    // Getters & Setters
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating(){
        return rating;
    }

    public void setRating(String rating){
        this.rating = rating;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }
}
