package com.tsi.o.blidi.program;

import com.tsi.o.blidi.program.Film.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmTests {

    private Film testFilm = new Film(13,"King Kong","Gorilla","18+",120,1);

    @Test
    public void testGetFilmId(){
        Assertions.assertEquals(13,testFilm.getFilm_id(),"Film ID not found");
    }

    @Test
    public void testSetFilmId(){
        testFilm.setFilm_id(15);
        Assertions.assertEquals(15,testFilm.getFilm_id(),"Film ID not set correctly");
    }

    @Test
    public void testGetTitle(){
        Assertions.assertEquals("King Kong",testFilm.getTitle(),"Title not found");
    }

    @Test
    public void testSetTitle(){
        testFilm.setTitle("John Wick 2");
        Assertions.assertEquals("John Wick 2",testFilm.getTitle(),"Title not set correctly");
    }

    @Test
    public void testGetRating(){
        Assertions.assertEquals("18+",testFilm.getRating(),"Rating Incorrect");
    }

    @Test
    public void testSetRating(){
        testFilm.setRating("PG13");
        Assertions.assertEquals("PG13", testFilm.getRating(),"Rating not set correctly");
    }



}
