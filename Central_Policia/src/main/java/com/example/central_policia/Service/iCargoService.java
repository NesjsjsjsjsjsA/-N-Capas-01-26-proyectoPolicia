package com.example.central_policia.Service;

import com.example.central_policia.Model.DTOs.RegisterCargoRequestDTO;
import com.example.central_policia.Model.Entity.Person;

import java.util.List;

public interface iCargoService {

    String registrarCargos(RegisterCargoRequestDTO request);

    List<Person> obtenerPersonasConCargos();

    List<Person> obtenerTop3MasBuscados();
}
