package com.example.central_policia.ExceptionHandler;

/**
 * Se lanza cuando se intenta registrar un cargo con un código de policía
 * que no existe en el sistema.
 */
public class PoliciaNotFoundException extends RuntimeException {
    public PoliciaNotFoundException(String codigo) {
        super("No se encontró ningún policía con el código: " + codigo);
    }
}
