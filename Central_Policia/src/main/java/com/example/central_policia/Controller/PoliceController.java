package com.example.central_policia.Controller;

import com.example.central_policia.Model.DTOs.GenericResponse;
import com.example.central_policia.Model.DTOs.PersonDTO;
import com.example.central_policia.Model.DTOs.PoliciaDTO;
import com.example.central_policia.Service.iPoliceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/police")
@RequiredArgsConstructor
public class PoliceController {

    private final iPoliceService policeService;

    @PostMapping("/register")
    ResponseEntity<GenericResponse> registerPolice(@RequestBody @Valid PoliciaDTO policiaDTO, String dui) {
        return GenericResponse.builder()
                .message("Policia creada con éxito")
                .data(policeService.registerPolicia(policiaDTO, dui))
                .status(HttpStatus.OK)
                .build().buildResponse();
    }
}
