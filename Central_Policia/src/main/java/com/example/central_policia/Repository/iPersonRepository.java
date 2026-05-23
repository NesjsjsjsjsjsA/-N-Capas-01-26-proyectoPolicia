package com.example.central_policia.Repository;

import com.example.central_policia.Model.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface iPersonRepository extends JpaRepository<Person, UUID> {

    Optional<Person> findByDui(String dui);
}
