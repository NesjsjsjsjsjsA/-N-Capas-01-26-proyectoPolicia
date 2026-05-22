package com.example.central_policia.Controller;

import com.example.central_policia.Model.DTOs.GenericResponse;
import com.example.central_policia.Model.DTOs.RegisterPoliceRequestDTO;
import com.example.central_policia.Service.iPoliceService;
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
    ResponseEntity<GenericResponse> registerPolice(@RequestBody RegisterPoliceRequestDTO request) {
        return GenericResponse.builder()
                .message("Policia creada con éxito")
                .data(policeService.registerPolice(request))
                .status(HttpStatus.OK)
                .build().buildResponse();
    }
}
