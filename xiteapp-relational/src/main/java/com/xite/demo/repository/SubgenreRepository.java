package com.xite.demo.repository;

import com.xite.demo.model.Subgenre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SubgenreRepository extends CrudRepository<Subgenre, Long> {

    @Query("SELECT s FROM Subgenre as s WHERE s.subgenreName = ?1")
    Optional<Subgenre> findByName(String name);

    Optional<Subgenre> findById(Integer id);

    @Query("SELECT s FROM Subgenre as s WHERE s.id= ?1 OR s.subgenreName = ?2")
    Optional<Subgenre> findbyIdOrName(Integer id, String name);

    @Override
    Subgenre save(Subgenre s);
}