package com.example.central_policia.Repository;

import com.example.central_policia.Model.Entity.Policia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface iPoliciaRepository extends JpaRepository<Policia, UUID> {

    @Query("SELECT u FROM Policia u WHERE u.placa = :placaOficial")
    Policia findCopByPlaca(String placaOficial);
}
