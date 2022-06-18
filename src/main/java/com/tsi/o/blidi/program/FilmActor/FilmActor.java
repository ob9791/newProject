package com.tsi.o.blidi.program.FilmActor;

import javax.persistence.*;

@Entity
@Table(name="film_actor")

public class FilmActor {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int film_id;

    private int actor_id;
    // Constructor

    public FilmActor(int actor_id, int film_id) {
        this.actor_id = actor_id;
        this.film_id = film_id;
    }

    public FilmActor(){}

    // Getters n setters
    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }
}
