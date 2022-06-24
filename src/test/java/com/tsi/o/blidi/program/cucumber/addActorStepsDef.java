package com.tsi.o.blidi.program.cucumber;

import com.tsi.o.blidi.program.Actor.Actor;
import com.tsi.o.blidi.program.Actor.ActorRepository;
import com.tsi.o.blidi.program.Category.CategoryRepository;
import com.tsi.o.blidi.program.Film.FilmRepository;
import com.tsi.o.blidi.program.FilmActor.FilmActorRepository;
import com.tsi.o.blidi.program.FilmCategory.FilmCategoryRepository;
import com.tsi.o.blidi.program.Language.LanguageRepository;
import com.tsi.o.blidi.program.MyFirstMicroServiceApplication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class addActorStepsDef {

    // mock the repositories
    private MyFirstMicroServiceApplication myFirstMicroServiceApplication;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private FilmActorRepository filmActorRepository;
    @Mock
    private FilmCategoryRepository filmCategoryRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private LanguageRepository languageRepository;
    @BeforeEach
    void setup(){
        actorRepository =mock(ActorRepository.class);
        myFirstMicroServiceApplication = new MyFirstMicroServiceApplication(actorRepository, categoryRepository, filmRepository, filmActorRepository, filmCategoryRepository, languageRepository);
    }
    int id;
    Actor testActor;
    String Expected;
    String Actual;
    @Given("I have the actor info")
    public void i_have_the_actor_info() {
        int id = 5;
        testActor = new Actor("testFName","testLName");
        testActor.setActorId(id);
    }
    @When("I input the data into the database")
    public void i_input_the_data_into_the_database() {

        setup();
        Actual = myFirstMicroServiceApplication.addActor(testActor.getFirst_name(), testActor.getLast_name());

    }
    @Then("I get the success return string")
    public void i_get_the_success_return_string() {
        Expected = "saved";
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"success string returned");

    }

}
