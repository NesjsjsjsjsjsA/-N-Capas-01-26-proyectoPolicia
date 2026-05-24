package com.example.central_policia.Repository;

import com.example.central_policia.Model.Entity.EstacionPolicial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface iEstacionPolicialRepository extends JpaRepository<EstacionPolicial, Long> {
    @Query("select u from EstacionPolicial u where u.id = :idEstacion")
    EstacionPolicial findEstId(Long idEstacion);
}
