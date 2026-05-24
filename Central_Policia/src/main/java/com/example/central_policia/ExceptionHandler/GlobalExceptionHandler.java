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
    public ResponseEntity<GenericResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return GenericResponse.builder()
                .data(errorTool.mapErrors(ex.getBindingResult().getFieldErrors()))
                .status(HttpStatus.BAD_REQUEST)
                .build().buildResponse();
    }

    @ExceptionHandler(FindPerson.class)
    public ResponseEntity<GenericResponse> handlePersonaYaExiste(FindPerson ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                LocalDateTime.now(),
                ex.getMessage()
        );
        return GenericResponse.builder()
                .data(errorResponse)
                .status(HttpStatus.CONFLICT)
                .build().buildResponse();
    }

    /**
     * Se activa cuando se registra un cargo con un código de policía inexistente.
     * Requerimiento: "si alguien intenta ingresar un código de un policía que no
     * existe, deberá lanzar una excepción".
     */
    @ExceptionHandler(PoliciaNotFoundException.class)
    public ResponseEntity<GenericResponse> handlePoliciaNoEncontrado(PoliciaNotFoundException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                LocalDateTime.now(),
                ex.getMessage()
        );
        return GenericResponse.builder()
                .data(errorResponse)
                .status(HttpStatus.NOT_FOUND)
                .build().buildResponse();
    }

    /**
     * Se activa cuando se intenta registrar cargos a una persona cuyo DUI no existe.
     */
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<GenericResponse> handlePersonaNoEncontrada(PersonNotFoundException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                LocalDateTime.now(),
                ex.getMessage()
        );
        return GenericResponse.builder()
                .data(errorResponse)
                .status(HttpStatus.NOT_FOUND)
                .build().buildResponse();
    }

    /**
     * Captura genérica para cualquier excepción no controlada.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse> handleGenericException(Exception ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                LocalDateTime.now(),
                "Error interno del servidor: :( " + ex.getMessage()
        );
        return GenericResponse.builder()
                .data(errorResponse)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build().buildResponse();
    }
}
