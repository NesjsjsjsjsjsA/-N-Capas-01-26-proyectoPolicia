package com.example.central_policia.Repository;

import com.example.central_policia.Model.Police;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface iPoliceRepository extends JpaRepository<Police, UUID> {

    @Query("SELECT u FROM Police u WHERE u.placaOficial = :placaOficial")
    Police findPoliceByPlaca(String placaOficial);

    @Query("SELECT u FROM Police u WHERE u.numeroIdentificacion = :codigo")
    Optional<Police> findByCodigo(String codigo);
}
