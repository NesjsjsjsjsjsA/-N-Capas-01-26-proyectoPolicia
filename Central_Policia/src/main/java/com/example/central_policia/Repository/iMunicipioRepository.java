package com.example.central_policia.Repository;

import com.example.central_policia.Model.Entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface iMunicipioRepository extends JpaRepository <Municipio,Long> {
    @Query("select u from Municipio u where u.id = :id")
    Municipio findMunById(Long id);
}
