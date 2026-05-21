package com.example.central_policia.Repository;

import com.example.central_policia.Model.Police;
import org.springframework.data.jpa.repository.Query;

public interface iPoliceRepository {

    @Query("select u from Police u where u.placaOficial = :placaOficial or u.DUI= :dui")
    Police findPoliceByPlaca(Integer DUI, String name);
}
