package com.tsi.o.blidi.program;

import com.tsi.o.blidi.program.FilmCategory.FilmCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmCategoryTests {

    private FilmCategory testFilmCat = new FilmCategory(10,15);

    @Test
    public void testGetFilmCatID(){
        Assertions.assertEquals(15,testFilmCat.getCategory_id(),"Film Category ID is not initialised");
    }

    @Test
    public void testSetFilmCatID(){
        testFilmCat.setCategory_id(24);
        Assertions.assertEquals(24,testFilmCat.getCategory_id(),"FILM CAT ID NOT SET CORRECTLY");
    }

    @Test
    public void testGetFilm_idCat(){
        Assertions.assertEquals(10,testFilmCat.getFilm_id(),"Test failed");
    }

    @Test
    public void testSetFilm_idCat(){
        testFilmCat.setFilm_id(31);
        Assertions.assertEquals(31,testFilmCat.getFilm_id(),"Film id not set correctly");
    }

}
