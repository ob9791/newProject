package com.tsi.o.blidi.program.FilmCategory;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmCategoryRepository extends CrudRepository<FilmCategory, Integer> {

    List<FilmCategory> findByCategory_id (int category_id);

}