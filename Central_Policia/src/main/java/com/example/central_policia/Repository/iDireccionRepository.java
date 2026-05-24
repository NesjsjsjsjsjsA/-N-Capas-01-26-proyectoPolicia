package com.example.central_policia.Repository;

import com.example.central_policia.Model.Entity.Direccion;
import com.example.central_policia.Model.Entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface iDireccionRepository extends JpaRepository<Direccion, Long> {

    @Query("select u from Direccion u where u.municipio.id =: id AND u.calle =: calle")
    Direccion findDireccionByMunAndCalle(Long id, String calle);
}
