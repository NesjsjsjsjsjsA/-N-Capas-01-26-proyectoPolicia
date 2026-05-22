package com.example.central_policia.Repository;

import com.example.central_policia.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface iPersonRepository extends JpaRepository<Person, UUID> {

    @Query("SELECT u FROM Person u WHERE u.DUI = :dui")
    Person findPersonByDUI(String dui);

    @Query("SELECT u FROM Person u WHERE u.DUI = :dui")
    Optional<Person> findByDUI(String dui);
}
