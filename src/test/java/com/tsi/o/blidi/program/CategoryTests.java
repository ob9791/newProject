package com.tsi.o.blidi.program;

import com.tsi.o.blidi.program.Category.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTests {

    private Category testCat = new Category(3,"Children");

    @Test
    public void testGetCategoryId(){
        Assertions.assertEquals(3,testCat.getCategoryId(),"id not found");

    }

    @Test
    public void testSetCategoryId(){
        testCat.setCategoryId(5);
        Assertions.assertEquals(5,testCat.getCategoryId(),"id not set correctly");
    }

    @Test
    public void testGetCategoryName(){
        Assertions.assertEquals("Children",testCat.getName(),"Category name not found");
    }

    @Test
    public void testSetCategoryName(){
        testCat.setName("Horror");
        Assertions.assertEquals("Horror",testCat.getName(),"Category name not set correctly");
    }


}
