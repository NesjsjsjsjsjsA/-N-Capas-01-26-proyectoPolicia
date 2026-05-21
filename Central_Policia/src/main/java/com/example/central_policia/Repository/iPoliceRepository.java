package com.example.central_policia.Repository;

import com.example.central_policia.Model.Police;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface iPoliceRepository extends JpaRepository<Police, UUID> {

    @Query("select u from Police u where u.placaOficial = :placaOficial")
    Police findPoliceByPlaca(String placaOficial);
}
