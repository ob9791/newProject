package com.tsi.o.blidi.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorTests {

    Actor testActor = new Actor("first_name", "last_name");
    Actor testActor2 = new Actor();



    @Test
    public void testActor(){

        Assertions.assertEquals("first_name",testActor.getFirst_name(), "first_name is not initialised");
        Assertions.assertEquals("last_name", testActor.getLast_name(), "last_name is not initialised");

        testActor2.setFirst_name("testFName");
        Assertions.assertEquals("testFName", testActor2.getFirst_name(),"First Name Does not Exist");
        testActor2.setLast_name("testLName");
        Assertions.assertEquals("testLName", testActor2.getLast_name(),"Last Name does not Exist");


    }

}
