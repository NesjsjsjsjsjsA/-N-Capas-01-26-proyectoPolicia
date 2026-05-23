package com.example.central_policia.Repository;

import com.example.central_policia.Model.Entity.Policia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface iPoliciaRepository extends JpaRepository<Policia, Long> {

    /**
     * Busca un policía por su número de identificación (código).
     * Si no existe, el servicio lanzará PoliciaNotFoundException.
     */
    @Query("SELECT p FROM Policia p WHERE p.numeroIdentificacion = :codigo")
    Optional<Policia> findByCodigo(String codigo);
}
