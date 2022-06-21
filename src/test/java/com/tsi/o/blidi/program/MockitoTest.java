package com.tsi.o.blidi.program;

import com.tsi.o.blidi.program.Actor.Actor;
import com.tsi.o.blidi.program.Actor.ActorRepository;
import com.tsi.o.blidi.program.Category.Category;
import com.tsi.o.blidi.program.Category.CategoryRepository;
import com.tsi.o.blidi.program.Film.Film;
import com.tsi.o.blidi.program.Film.FilmRepository;
import com.tsi.o.blidi.program.FilmActor.FilmActor;
import com.tsi.o.blidi.program.FilmActor.FilmActorRepository;
import com.tsi.o.blidi.program.FilmCategory.FilmCategory;
import com.tsi.o.blidi.program.FilmCategory.FilmCategoryRepository;
import com.tsi.o.blidi.program.Language.Language;
import com.tsi.o.blidi.program.Language.LanguageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
// the below mocks all the repositories we need, creates the blueprints, mock arrays/data need to be added.
public class MockitoTest {
    @Mock
    private MyFirstMicroServiceApplication myFirstMicroServiceApplication;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private FilmCategoryRepository filmCategoryRepository;
    @Mock
    private FilmActorRepository filmActorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private LanguageRepository languageRepository;


    @BeforeEach
    void setUp() {

        actorRepository = mock(ActorRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        filmRepository = mock(FilmRepository.class);
        filmActorRepository = mock(FilmActorRepository.class);
        filmCategoryRepository = mock(FilmCategoryRepository.class);
        languageRepository = mock(LanguageRepository.class);
        myFirstMicroServiceApplication = new MyFirstMicroServiceApplication(actorRepository, categoryRepository, filmRepository, filmActorRepository, filmCategoryRepository, languageRepository);

    }

    @Test
    public void getAllActors() {

        myFirstMicroServiceApplication.getALLActors();
        verify(actorRepository).findAll();
    }

    @Test
    public void testAddActor() {

        Actor savedActor = new Actor("testFirstname", "testLastName");
        String expected = "saved";
        String Actual = myFirstMicroServiceApplication.addActor(savedActor.getFirst_name(), savedActor.getLast_name());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected, Actual, "Actor is not Saved into database");

    }

    @Test
    public void testDeleteActor() {
        Actor deletedActor = new Actor("testFirstname", "testLastname");
        deletedActor.setActor_id(1);
        String Actual = myFirstMicroServiceApplication.deleteActorById(1);
        String Expected = "Deleted Successfully";
        ArgumentCaptor<Integer> integerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(actorRepository).deleteById(integerArgumentCaptor.capture());
        Assertions.assertEquals(Expected, Actual, "Actor not deleted");

    }

    @Test
    public void testUpdateActor() {
        Actor updateActor = new Actor("testFirstname", "testLastname");
        updateActor.setActor_id(1);
        when(actorRepository.findById(1)).thenReturn(Optional.of(updateActor));
        String Actual = myFirstMicroServiceApplication.updateActor(updateActor.getActor_id(), updateActor.getFirst_name(), updateActor.getLast_name());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        String Expected = "Updated Successfully";
        Assertions.assertEquals(Expected, Actual, "Shopper was not updated.");
    }



    // FILM TESTS

    @Test
    public void testGetAllFilms(){
        //Assertions.assertEquals(1,1,"wrong"); made a dumb test to ensure we are reaching the repo

        // setup mock environment for filmRepository

        //create a list of movies
        List<Film> filmList = new ArrayList<Film>();
        //using contrusctor, we construct a new movie to be added to the mock list
        Film film1 = new Film(1,"JohN wICK","sick movie","18+",120,1);
        filmList.add(film1);

        //  created an iterable for the list of films
        Iterable<Film> filmIterable = filmList;

        // when the mock crud function is called, this returns the iterable we contsructed above.
        when(filmRepository.findAll()).thenReturn(filmIterable);

        // setting the expected and actual: actual is the function we are testing, expected is the mock we have created
        Iterable<Film> expected =  filmIterable;
        Iterable<Film> actual = myFirstMicroServiceApplication.getAllFilms();

        // actual test: sees if the film iterable performs the same function as the get all films crud function
        Assertions.assertEquals(expected,actual,"test failure");

    }

    @Test
    public void testGetFilmById(){
        // create list of movies and mock movie like above
        List<Film> filmList = new ArrayList<Film>();
        Film film1 = new Film(1,"JohN wICK","sick movie","18+",120,1);
        filmList.add(film1);

// try to mock the function using the film example I created
        when(filmRepository.existsById(film1.getFilm_id())).thenReturn(true);
        when(filmRepository.findById(film1.getFilm_id())).thenReturn(Optional.of(film1));


        Optional<Film>  expected = Optional.of(film1);
        Optional<Film> actual = myFirstMicroServiceApplication.getFilmById(1);

        Assertions.assertEquals(expected,actual,"Id is not the same");

    }

    @Test
    public void testGetAllFilmCategories(){
        List<FilmCategory> filmCatList = new ArrayList<FilmCategory>();
        FilmCategory testFilmCat = new FilmCategory(2,1);
        filmCatList.add(testFilmCat);

        Iterable<FilmCategory> filmCatIterable = filmCatList;

        when(filmCategoryRepository.findAll()).thenReturn(filmCatIterable);

        Iterable<FilmCategory> expected = filmCatIterable;
        Iterable<FilmCategory> actual = myFirstMicroServiceApplication.getAllFilmCategories();

        Assertions.assertEquals(expected,actual,"Film ID and Catgegory ID do not match");
    }

    @Test
    public void testGetAllFilmActors(){
        List<FilmActor> filmActorList = new ArrayList<FilmActor>();
        FilmActor testFilmActor = new FilmActor(3,4);
        filmActorList.add(testFilmActor);

        Iterable<FilmActor> filmActorIterable = filmActorList;

        when(filmActorRepository.findAll()).thenReturn(filmActorIterable);

        Iterable<FilmActor> expected = filmActorIterable;
        Iterable<FilmActor> actual = myFirstMicroServiceApplication.getAllFilmActors();

        Assertions.assertEquals(expected,actual,"Actor ID and Film ID do not match");

    }

    @Test
    public void testGetAllLanguages(){
        List<Language> languageList = new ArrayList<Language>();
        Language testLang = new Language(3,"Japanese");
        languageList.add(testLang);

        Iterable<Language> languageIterable = languageList;

        when(languageRepository.findAll()).thenReturn(languageIterable);

        Iterable<Language> expected = languageIterable;
        Iterable<Language> actual = myFirstMicroServiceApplication.getAllLanguages();

        Assertions.assertEquals(expected,actual,"Language not initialised");
    }

    @Test
    public void testGetAllCategories(){
        List<Category> categoryList = new ArrayList<Category>();
        Category testCategory = new Category(5,"Horror");
        categoryList.add(testCategory);

        Iterable<Category> categoryIterable = categoryList;

        when(categoryRepository.findAll()).thenReturn(categoryIterable);

        Iterable<Category> expected = categoryIterable;
        Iterable<Category> actual = myFirstMicroServiceApplication.getAllCategories();

        Assertions.assertEquals(expected,actual,"Category not initialised");
    }



}



