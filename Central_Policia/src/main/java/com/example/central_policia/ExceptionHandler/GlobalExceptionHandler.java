package com.example.central_policia.ExceptionHandler;

import com.example.central_policia.Model.DTOs.GenericResponse;
import com.example.central_policia.Utils.ErrorTool;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ErrorTool errorTool;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        return GenericResponse.builder()
                .data(errorTool.mapErrors(ex.getBindingResult().getFieldErrors()))
                .status(HttpStatus.BAD_REQUEST)
                .build().buildResponse();
    }

    @ExceptionHandler(FindPerson.class)
    public ResponseEntity<GenericResponse> handlePersonaYaExiste(FindPerson ex) {
        return GenericResponse.builder()
                .data(new CustomErrorResponse(LocalDateTime.now(), ex.getMessage()))
                .status(HttpStatus.CONFLICT)
                .build().buildResponse();
    }

    @ExceptionHandler(PoliciaNotFoundException.class)
    public ResponseEntity<GenericResponse> handlePoliciaNoEncontrado(PoliciaNotFoundException ex) {
        return GenericResponse.builder()
                .data(new CustomErrorResponse(LocalDateTime.now(), ex.getMessage()))
                .status(HttpStatus.NOT_FOUND)
                .build().buildResponse();
    }

    @ExceptionHandler(PoliceNotFoundException.class)
    public ResponseEntity<GenericResponse> handlePoliceNoEncontrado(PoliceNotFoundException ex) {
        return GenericResponse.builder()
                .data(new CustomErrorResponse(LocalDateTime.now(), ex.getMessage()))
                .status(HttpStatus.NOT_FOUND)
                .build().buildResponse();
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<GenericResponse> handlePersonaNoEncontrada(PersonNotFoundException ex) {
        return GenericResponse.builder()
                .data(new CustomErrorResponse(LocalDateTime.now(), ex.getMessage()))
                .status(HttpStatus.NOT_FOUND)
                .build().buildResponse();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse> handleGenericException(Exception ex) {
        return GenericResponse.builder()
                .data(new CustomErrorResponse(LocalDateTime.now(), "Error interno del servidor: " + ex.getMessage()))
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build().buildResponse();
    }
}
