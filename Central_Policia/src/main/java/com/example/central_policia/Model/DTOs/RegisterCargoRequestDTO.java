package com.example.central_policia.Model.DTOs;

import lombok.Data;

import java.util.List;

/**
 * Payload para registrar cargos a una persona.
 *
 * Estructura esperada:
 * {
 *   "persona": {              <- datos de la persona acusada
 *     "name": "...",
 *     "DUI": "00000000-0",
 *     "depID": 1,
 *     "MunID": 1,
 *     "tel": "0000-0000"
 *   },
 *   "cargos": [
 *     {
 *       "tipo": "PROCESAL",
 *       "codigoPolicia": "PNC-001",
 *       "descripcion": "...",
 *       "acusador": {
 *         "nombre": "...",
 *         "dui": "00000000-0"
 *       }
 *     }
 *   ]
 * }
 */
@Data
public class RegisterCargoRequestDTO {

    // Datos de la persona acusada
    private PersonDTO persona;

    private List<CargoItemDTO> cargos;
}
