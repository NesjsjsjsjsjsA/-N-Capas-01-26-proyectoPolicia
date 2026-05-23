package com.example.central_policia.Model.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class RegisterCargoRequestDTO {

    private PersonDTO persona;

    private List<CargoItemDTO> cargos;
}
