package com.example.central_policia.Controller;

import com.example.central_policia.Model.DTOs.GenericResponse;
import com.example.central_policia.Model.DTOs.RegisterCargoRequestDTO;
import com.example.central_policia.Service.iCargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cargos")
@RequiredArgsConstructor
public class CargoController {

    private final iCargoService cargoService;

    /**
     * POST /api/cargos/register
     *
     * Registra uno o varios cargos a una persona.
     * Si el código del policía no existe → 404 PoliciaNotFoundException
     * Si el DUI del acusado no existe  → se crea automáticamente con los datos recibidos
     *
     * Ejemplo de body:
     * {
     *   "persona": { "name": "Juan Pérez", "DUI": "12345678-9", "depID": 10, "MunID": 1, "tel": "7777-7777" },
     *   "cargos": [
     *     {
     *       "tipo": "PENAL",
     *       "codigoPolicia": "PNC-001",
     *       "descripcion": "Robo con violencia",
     *       "acusador": { "nombre": "María López", "dui": "98765432-1" }
     *     }
     *   ]
     * }
     */
    @PostMapping("/register")
    public ResponseEntity<GenericResponse> registrarCargos(@RequestBody RegisterCargoRequestDTO request) {
        return GenericResponse.builder()
                .message(cargoService.registrarCargos(request))
                .status(HttpStatus.CREATED)
                .build().buildResponse();
    }

    /**
     * GET /api/cargos/con-cargos
     *
     * Retorna todas las personas que tienen al menos un cargo registrado.
     */
    @GetMapping("/con-cargos")
    public ResponseEntity<GenericResponse> personasConCargos() {
        return GenericResponse.builder()
                .message("Personas con cargos registrados")
                .data(cargoService.obtenerPersonasConCargos())
                .status(HttpStatus.OK)
                .build().buildResponse();
    }

    /**
     * GET /api/cargos/top3
     *
     * Retorna los 3 individuos con más cargos acumulados (los más buscados).
     */
    @GetMapping("/top3")
    public ResponseEntity<GenericResponse> top3MasBuscados() {
        return GenericResponse.builder()
                .message("Top 3 más buscados")
                .data(cargoService.obtenerTop3MasBuscados())
                .status(HttpStatus.OK)
                .build().buildResponse();
    }
}
