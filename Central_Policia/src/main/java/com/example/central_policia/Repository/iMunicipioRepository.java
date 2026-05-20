package com.example.central_policia.Repository;

import com.example.central_policia.Model.Direcciones.Departamento;
import com.example.central_policia.Model.Direcciones.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface iMunicipioRepository extends JpaRepository <Municipio,Long> {
    @Query("select u from Municipio u where u.municipio_id = :id")
    Municipio findMunById(Long id);
}
