package com.tsi.o.blidi.program;

import com.tsi.o.blidi.program.Actor.Actor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorTests {

    private Actor testActor = new Actor("Tommy", "Shelby");
    private Actor testActor2 = new Actor(5,"John", "Shelby");

    // unit testing helps finds bugs early in the development phase

    @Test
    public void testGetActorId(){
        Assertions.assertEquals(5,testActor2.getActorId(),"id not found");
    }

    @Test
    public void testSetActorId(){
        testActor2.setActorId(10);
        Assertions.assertEquals(10,testActor2.getActorId(),"id not set");
    }

    @Test
    public void testGetFirstName(){
        Assertions.assertEquals("Tommy",testActor.getFirst_name(),"First name not found");
    }

    @Test
    public void testSetFirstName(){
        testActor.setFirst_name("test");
        Assertions.assertEquals("test",testActor.getFirst_name(),"First name not set");
    }

    // remember: setting name/id overwrites the actor we created above. therefore using assertequals: test expected, use getname method to get actual name(unless set differently), return message if null

}
