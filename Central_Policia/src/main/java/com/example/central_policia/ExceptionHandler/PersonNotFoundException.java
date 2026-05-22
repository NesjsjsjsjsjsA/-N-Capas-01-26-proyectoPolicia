package com.example.central_policia.ExceptionHandler;

/**
 * Se lanza cuando se intenta registrar cargos a una persona
 * cuyo DUI no existe en el sistema.
 */
public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String dui) {
        super("No se encontró ninguna persona con el DUI: " + dui);
    }
}
