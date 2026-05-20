package com.example.central_policia.Utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ErrorTool {
    public Map<String, List<String>> mapErrors(List<FieldError> fieldErrors){
        Map<String , List<String>> errorsMap= new HashMap<>();

        fieldErrors.forEach(error -> {

            String field = error.getField();

            List<String> errors = errorsMap.getOrDefault(field, new ArrayList<>());

            errors.add(error.getDefaultMessage());

            errorsMap.put(field,errors);
        });

        return errorsMap;
    }
}
