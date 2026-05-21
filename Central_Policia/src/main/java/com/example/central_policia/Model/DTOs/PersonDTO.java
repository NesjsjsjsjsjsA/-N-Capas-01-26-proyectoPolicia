package com.example.central_policia.Model.DTOs;

import com.example.central_policia.Model.Direcciones.Departamento;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.UUID;

@Data
public class PersonDTO {

    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El nombre debe de contener letras!")
    private String name;

    @Pattern(regexp = "^[0-9]{8}-[0-9]$")
    private String DUI;

    private Long depID;

    private Long MunID;

    //Es necesario que sea solo numérico
    @Pattern(regexp = "^[0-9]{4}-[0-9]${4}")
    private String tel;

}
