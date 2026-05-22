package com.example.central_policia.Model.DTOs;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PersonDTO {

    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre debe contener solo letras!")
    private String name;

    @Pattern(regexp = "^[0-9]{8}-[0-9]$", message = "El DUI debe tener el formato 00000000-0")
    private String DUI;

    private Long depID;

    // Nota: Lombok genera getMunID() para este campo
    private Long MunID;

    @Pattern(regexp = "^[0-9]{4}-[0-9]{4}$", message = "El teléfono debe tener el formato 0000-0000")
    private String tel;
}
