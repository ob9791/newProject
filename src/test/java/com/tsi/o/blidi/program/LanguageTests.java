package com.tsi.o.blidi.program;

import com.tsi.o.blidi.program.Language.Language;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LanguageTests {

private Language testLang = new Language(4,"Mandarin");

    @Test
    public void testGetLangId(){
        Assertions.assertEquals(4,testLang.getLanguage_id(),"Language id not found");
    }

    @Test
    public void testSetLangId(){
        testLang.setLanguage_id(6);
        Assertions.assertEquals(6,testLang.getLanguage_id(),"Language id not set correctly");
    }

    @Test
    public void testGetLangName(){
        Assertions.assertEquals("Mandarin",testLang.getLang(),"Language Not found");
    }

    @Test
    public void testSetLangName(){
        testLang.setLang("English");
        Assertions.assertEquals("English",testLang.getLang(),"Language not set correctly");
    }


}
