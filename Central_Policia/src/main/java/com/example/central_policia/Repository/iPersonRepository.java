package com.example.central_policia.Repository;

import com.example.central_policia.Model.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface iPersonRepository extends JpaRepository<Person, UUID> {

    @Query("SELECT u FROM Person u WHERE u.dui = :dui")
    Person findPersonByDUI(String dui);

    Optional<Person> findByDui(String dui);
}
