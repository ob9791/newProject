package com.tsi.o.blidi.program.FilmActor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmActorRepository extends CrudRepository<FilmActor, Integer> {

    List<FilmActor> findByActor_id(int actor_id);

}
