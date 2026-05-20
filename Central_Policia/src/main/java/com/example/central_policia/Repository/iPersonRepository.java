package com.example.central_policia.Repository;

import com.example.central_policia.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface iPersonRepository extends JpaRepository<Person, UUID> {

    @Query("select u from Person u where u.name = :name or u.DUI= :dui")
    Person findPersonByDUI(Integer DUI, String name);
}
