package com.example.central_policia.Model.DTOs;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class DireccionDTO {

    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")
    private String calleDTO;

    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")
    private String coloniaDTO;

    private Long municipioId;


}
