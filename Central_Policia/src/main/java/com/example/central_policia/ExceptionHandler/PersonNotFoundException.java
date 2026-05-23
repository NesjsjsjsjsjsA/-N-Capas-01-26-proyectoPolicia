package com.example.central_policia.ExceptionHandler;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String dui) {
        super("No se encontró ninguna persona con el DUI: " + dui);
    }
}
