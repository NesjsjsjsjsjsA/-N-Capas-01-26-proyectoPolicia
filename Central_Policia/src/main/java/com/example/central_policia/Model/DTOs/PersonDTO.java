package com.example.central_policia.Model.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonDTO {

    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "name must be alphanumeric")
    private String name;

    @Email
    private String email;

}
