package com.xite.demo.repository;

import com.xite.demo.model.Genre;
import com.xite.demo.model.Subgenre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.Set;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {


    @Query("SELECT g FROM Genre as g WHERE g.genreName = ?1")
    Optional<Genre> findByGenreName(String name);

    Optional<Genre> findById(Long aLong);

    @Query("SELECT g FROM Genre as g WHERE g.id= ?1 OR g.genreName = ?2")
    Optional<Genre> findbyIdOrName(Long id, String name);


}