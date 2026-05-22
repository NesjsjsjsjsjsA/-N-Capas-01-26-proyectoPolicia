package com.example.central_policia.ExceptionHandler;

public class PoliceNotFoundException extends RuntimeException {
    public PoliceNotFoundException(String codigo) {
        super("No se encontró ningún policía con el código: " + codigo);
    }
}
