package com.example.central_policia.Model.DTOs;

import lombok.Data;

@Data
public class PoliceDTO {

    private String numeroIdentificacion;

    private String placaOficial;

    private Long policeStationID;
}
