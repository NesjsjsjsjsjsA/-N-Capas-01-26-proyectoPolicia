package com.example.central_policia.Repository;

import com.example.central_policia.Model.Cargo;
import com.example.central_policia.Model.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface iCargoRepository extends JpaRepository<Cargo, UUID> {

    @Query("SELECT DISTINCT c.acusado FROM Cargo c")
    List<Person> findAllPersonsWithCargos();

    @Query("SELECT c.acusado FROM Cargo c GROUP BY c.acusado ORDER BY COUNT(c) DESC")
    List<Person> findTopMostWanted(Pageable pageable);
}
