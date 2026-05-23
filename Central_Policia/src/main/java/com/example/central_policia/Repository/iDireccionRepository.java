package com.example.central_policia.Repository;

import com.example.central_policia.Model.Entity.Direccion;
import com.example.central_policia.Model.Entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface iDireccionRepository extends JpaRepository<Direccion, UUID> {

    @Query("select u from Direccion u where u.municipio =: municipio")
    Direccion findDireccionByMun(Municipio municipio);
}
