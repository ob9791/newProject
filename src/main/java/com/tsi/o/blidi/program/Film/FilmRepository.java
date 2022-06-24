package com.tsi.o.blidi.program.Film;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface FilmRepository extends CrudRepository<Film, Integer> {
    Iterable<Film> findByTitleLike(String title);

    //Iterable<Film> findByFilmId(List<Integer> );

    //Iterable<Film> findByFilmId(List<Integer> filmList);

    //List<Film> findByFilmId(List<Integer> filmList);




}
