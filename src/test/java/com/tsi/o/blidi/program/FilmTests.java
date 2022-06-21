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

    @Test
    public void testGetDescription(){
        Assertions.assertEquals("Gorilla",testFilm.getDescription(),"Description incorrect");
    }

    @Test
    public void testSetDescription(){
        testFilm.setDescription("Gorilla and Dinosaur");
        Assertions.assertEquals("Gorilla and Dinosaur",testFilm.getDescription(),"Description not set correctly");
    }

    @Test
    public void testGetLength(){
        Assertions.assertEquals(120,testFilm.getLength(),"Incorrect Film Length");
    }

    @Test
    public void testSetLength(){
        testFilm.setLength(150);
        Assertions.assertEquals(150,testFilm.getLength(),"Movie Length not set correctly");
    }

    @Test
    public void testGetLanguage_id(){
        Assertions.assertEquals(1,testFilm.getLanguage_id(),"Incorrect Language ID");
    }

    @Test
    public void testSetLanguage_id(){
        testFilm.setLanguage_id(5);
        Assertions.assertEquals(5,testFilm.getLanguage_id(),"Language ID not set correctly");
    }



}
