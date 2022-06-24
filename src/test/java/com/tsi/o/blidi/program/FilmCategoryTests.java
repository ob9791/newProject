package com.tsi.o.blidi.program;

import com.tsi.o.blidi.program.FilmCategory.FilmCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmCategoryTests {

    private FilmCategory testFilmCat = new FilmCategory(10,15);

    @Test
    public void testGetFilmCatID(){
        Assertions.assertEquals(15,testFilmCat.getCategoryId(),"Film Category ID is not initialised");
    }

    @Test
    public void testSetFilmCatID(){
        testFilmCat.setCategoryId(24);
        Assertions.assertEquals(24,testFilmCat.getCategoryId(),"FILM CAT ID NOT SET CORRECTLY");
    }

    @Test
    public void testGetFilm_idCat(){
        Assertions.assertEquals(10,testFilmCat.getFilmId(),"Test failed");
    }

    @Test
    public void testSetFilm_idCat(){
        testFilmCat.setFilmId(31);
        Assertions.assertEquals(31,testFilmCat.getFilmId(),"Film id not set correctly");
    }

}
