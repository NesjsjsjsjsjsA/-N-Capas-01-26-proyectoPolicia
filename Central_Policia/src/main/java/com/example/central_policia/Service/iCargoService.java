package com.example.central_policia.Service;

import com.example.central_policia.Model.DTOs.RegisterCargoRequestDTO;
import com.example.central_policia.Model.Person;

import java.util.List;

public interface iCargoService {

    /**
     * Registra uno o varios cargos a una persona (acusado).
     * Lanza PoliciaNotFoundException si algún código de policía no existe.
     * Lanza PersonNotFoundException si el DUI del acusado no existe en el sistema.
     */
    String registrarCargos(RegisterCargoRequestDTO request);

    /**
     * Retorna todas las personas que tienen al menos un cargo registrado.
     */
    List<Person> obtenerPersonasConCargos();

    /**
     * Retorna las 3 personas con más cargos acumulados (los más buscados).
     */
    List<Person> obtenerTop3MasBuscados();
}
