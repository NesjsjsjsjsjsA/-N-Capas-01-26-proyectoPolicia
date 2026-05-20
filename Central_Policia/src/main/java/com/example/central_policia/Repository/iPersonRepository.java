package com.example.central_policia.Repository;

import com.example.central_policia.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface iPersonRepository extends JpaRepository<Persona, UUID> {
}
