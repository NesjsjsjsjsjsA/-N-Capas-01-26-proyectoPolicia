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

    @PostMapping("/register")
    ResponseEntity<GenericResponse> registrarCargos(@RequestBody RegisterCargoRequestDTO request) {
        return GenericResponse.builder()
                .message(cargoService.registrarCargos(request))
                .status(HttpStatus.CREATED)
                .build().buildResponse();
    }

    @GetMapping("/con-cargos")
    ResponseEntity<GenericResponse> personasConCargos() {
        return GenericResponse.builder()
                .message("Personas con cargos registrados")
                .data(cargoService.obtenerPersonasConCargos())
                .status(HttpStatus.OK)
                .build().buildResponse();
    }

    @GetMapping("/top3")
    ResponseEntity<GenericResponse> top3MasBuscados() {
        return GenericResponse.builder()
                .message("Top 3 más buscados")
                .data(cargoService.obtenerTop3MasBuscados())
                .status(HttpStatus.OK)
                .build().buildResponse();
    }
}
