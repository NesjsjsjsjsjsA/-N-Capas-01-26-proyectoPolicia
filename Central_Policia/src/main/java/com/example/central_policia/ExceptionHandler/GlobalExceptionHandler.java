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
    public ResponseEntity<GenericResponse> personFindFunct(FindPerson ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                LocalDateTime.now(),
                ex.getMessage()
        );
        return GenericResponse.builder()
                .data(errorResponse)
                .status(HttpStatus.CONFLICT)
                .build().buildResponse();
    }

    @ExceptionHandler(PoliceNotFoundException.class)
    public ResponseEntity<GenericResponse> handlePoliceNotFound(PoliceNotFoundException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                LocalDateTime.now(),
                ex.getMessage()
        );
        return GenericResponse.builder()
                .data(errorResponse)
                .status(HttpStatus.NOT_FOUND)
                .build().buildResponse();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse> handleGenericException(Exception ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                LocalDateTime.now(),
                "Error interno del servidor: " + ex.getMessage()
        );
        return GenericResponse.builder()
                .data(errorResponse)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build().buildResponse();
    }
}
