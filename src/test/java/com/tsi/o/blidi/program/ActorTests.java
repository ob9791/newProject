package com.tsi.o.blidi.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorTests {

   Actor testActor = new Actor("john","Doe");
   Actor sarah = new Actor("sarah","doe");
   Actor john = new Actor("john","smith");


   // Actor testActor2 = new Actor();
    //int expected = 5;




   public void example() {

        int x =5;
        int y= 4;

        System.out.println(x+y);




   }







    @Test
    public void testActor(){

        System.out.println(sarah.getLast_name());
        Assertions.assertEquals("Doe",testActor.getLast_name(), "first_name is not initialised");
        //Assertions.assertEquals("last_name", testActor.getLast_name(), "last_name is not initialised");

        //Assertions.assertEquals(expected, example(),"if example does not return 5, test failed");

        example();








    }

}
