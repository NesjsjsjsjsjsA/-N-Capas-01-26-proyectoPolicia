package com.example.central_policia.Controller;

import com.example.central_policia.Model.DTOs.GenericResponse;
import com.example.central_policia.Model.DTOs.PersonDTO;
import com.example.central_policia.Service.iPersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {

    private final iPersonService personService;

    @PostMapping("/register")
    ResponseEntity<GenericResponse> registerPerson(@RequestBody @Valid PersonDTO personDTO){

        return GenericResponse.builder()
                .message("Persona creada con éxito")
                .data(personService.registerPerson(personDTO))
                .status(HttpStatus.OK)
                .build().buildResponse();
    }
}
