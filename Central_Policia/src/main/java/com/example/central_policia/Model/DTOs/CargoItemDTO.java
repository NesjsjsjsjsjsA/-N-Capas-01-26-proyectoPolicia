package com.example.central_policia.Model.DTOs;

import com.example.central_policia.Model.Entity.TipoCargo;
import lombok.Data;

@Data
public class CargoItemDTO {

    private TipoCargo tipo;

    private String codigoPolicia;

    private AcusadorDTO acusador;

    private String descripcion;
}
