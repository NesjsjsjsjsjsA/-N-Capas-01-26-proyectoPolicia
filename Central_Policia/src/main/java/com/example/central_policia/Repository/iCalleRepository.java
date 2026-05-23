package com.example.central_policia.Repository;

import com.example.central_policia.Model.Entity.Calle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface iCalleRepository extends JpaRepository<Calle,Long> {
    @Query("select u from Calle u where u.id = :id")
    Calle findCalleById(Long id);


}
