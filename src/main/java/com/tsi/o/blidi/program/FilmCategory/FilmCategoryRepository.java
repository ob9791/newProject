package com.tsi.o.blidi.program.FilmCategory;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmCategoryRepository extends CrudRepository<FilmCategory, Integer> {
    //List<FilmCategory> findByCategoryId(int );
    //List<FilmCategory> findByCategoryId(int filmCatId);
    List<FilmCategory> findByCategoryId (int categoryId);



}
