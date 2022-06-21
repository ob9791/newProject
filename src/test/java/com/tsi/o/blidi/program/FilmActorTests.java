package com.tsi.o.blidi.program;

import com.tsi.o.blidi.program.FilmActor.FilmActor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmActorTests {

    private FilmActor testFilmActor = new FilmActor(5,7);

    @Test
    public void testGetActor_id(){
        Assertions.assertEquals(5,testFilmActor.getActor_id(),"FILM ACTOR ID IS NOT INITIALISED");
    }

    @Test
    public void testSetActor_id(){
        testFilmActor.setActor_id(10);
        Assertions.assertEquals(10,testFilmActor.getActor_id(),"FilmActor ID not set correctly");
    }

    @Test
    public void testGetFilm_id(){
        Assertions.assertEquals(7,testFilmActor.getFilm_id(),"FILM ACTOR FILM ID IS NOT INITIALISED");
    }

    @Test
    public void testSetFilm_id(){
        testFilmActor.setFilm_id(15);
        Assertions.assertEquals(15,testFilmActor.getFilm_id(),"Film_Id not set correctly");
    }
}
