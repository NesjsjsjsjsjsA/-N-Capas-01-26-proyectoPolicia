package com.example.central_policia.Model.DTOs;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PoliciaDTO {

    @Pattern(regexp = "^[0-9]{3}$")
    private String numeroIdentificacion;

    @Pattern(regexp = "^[a-zA-Z]{3}-[0-9]{3}$", message = "La placa debe tener el formato AAA-111")
    private String placaOficial;

    private Long policeStationID;
}
