package com.example.central_policia.Model.DTOs;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PersonDTO {

    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El nombre debe de contener letras!")
    private String name;

    @Pattern(regexp = "^[0-9]{8}-[0-9]$")
    private String DUI;

    private Long depID;

    private Long MunID;

    @Pattern(regexp = "^[0-9]{4}-[0-9]{4}$")
    private String tel;
}
