package com.tsi.o.blidi.program.Film;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {

    List<Film> findByTitleLikeOrDescriptionLike(String title, String description);
    List<Film> findByRating(String rating);
    List<Film> findByLanguage_id(int language_id);
    List<Film> findByLength(int length);

}
