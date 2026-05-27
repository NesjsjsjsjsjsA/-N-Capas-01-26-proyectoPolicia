package com.example.central_policia.ExceptionHandler;

public class PoliciaNotFoundException extends RuntimeException {
    public PoliciaNotFoundException(String codigo) {
        super("No se encontró ningún policía con el código: " + codigo);
    }
}
