package com.tsi.o.blidi.program.Film;

import javax.persistence.*;

@Entity
@Table(name="film")

public class Film{

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int film_id;
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

    public Film(int film_id, String title, String description, int length, int language_id) {
        this.film_id = film_id;
        this.title = title;
        this.description = description;
        this.length = length;
        this.language_id = language_id;
    }
    public Film(){}



    // Getters & Setters
    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
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

    public void setRating(){
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

    public void setLanguageId(int language_id) {
        this.language_id = language_id;
    }
}
