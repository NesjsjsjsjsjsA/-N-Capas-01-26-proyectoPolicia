package com.example.central_policia.ExceptionHandler;

public class FindPerson extends RuntimeException {
    public FindPerson(String message) {
        super(message);
    }
}
