package com.tsi.o.blidi.program;

import com.tsi.o.blidi.program.Actor.Actor;
import com.tsi.o.blidi.program.Actor.ActorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MyFirstMicroServiceApplication myFirstMicroServiceApplication;
    @Mock
    private ActorRepository actorRepository;

    @BeforeEach
    void setUp(){
        //myFirstMicroServiceApplication = new MyFirstMicroServiceApplication(actorRepository);

    }

    @Test
    public void getAllActors(){

        myFirstMicroServiceApplication.getALLActors();
        verify(actorRepository).findAll();
    }

    @Test
    public void testAddActor(){

        Actor savedActor = new Actor("testFirstname","testLastName");
        String expected = "saved";
        String Actual = myFirstMicroServiceApplication.addActor(savedActor.getFirst_name(),savedActor.getLast_name());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected,Actual,"Actor is not Saved into database");

    }

    @Test
    public void testDeleteActor(){
        Actor deletedActor = new Actor("testFirstname","testLastname");
        deletedActor.setActor_id(1);
        String Actual = myFirstMicroServiceApplication.deleteActorById(1);
        String Expected = "Deleted Successfully";
        ArgumentCaptor<Integer>integerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(actorRepository).deleteById(integerArgumentCaptor.capture());
        Assertions.assertEquals(Expected,Actual,"Actor not deleted");

    }

    @Test
    public void testUpdateActor(){
        Actor updateActor = new Actor("testFirstname", "testLastname");
        updateActor.setActor_id(1);
        when(actorRepository.findById(1)).thenReturn(Optional.of(updateActor));
        String Actual = myFirstMicroServiceApplication.updateActor(updateActor.getActor_id(), updateActor.getFirst_name(), updateActor.getLast_name());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        String Expected = "Updated Successfully";
        Assertions.assertEquals(Expected,Actual,"Shopper was not updated.");
    }

}
