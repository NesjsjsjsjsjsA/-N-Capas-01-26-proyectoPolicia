package com.example.central_policia.Model.DTOs;

import lombok.Data;

@Data
public class RegisterPoliceRequestDTO {

    private PersonDTO persona;

    private PoliceDTO policia;
}
