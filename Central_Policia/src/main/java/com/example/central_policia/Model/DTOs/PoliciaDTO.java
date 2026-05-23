package com.example.central_policia.Model.DTOs;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PoliciaDTO {

    @Pattern(regexp = "^[0-9]{4}-[0-9]{4}$")
    private String numeroIdentificacion;

    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")
    private String placaOficial;

    private Long policeStationID;
}
