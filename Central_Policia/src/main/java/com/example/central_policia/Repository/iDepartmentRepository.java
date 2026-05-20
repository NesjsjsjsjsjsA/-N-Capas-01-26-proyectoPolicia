package com.example.central_policia.Repository;

import com.example.central_policia.Model.Direcciones.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface iDepartmentRepository extends JpaRepository<Departamento, Long> {

    @Query("select u from Departamento u where u.departamento_id = :id")
    Departamento findDPById(Long id);
}
