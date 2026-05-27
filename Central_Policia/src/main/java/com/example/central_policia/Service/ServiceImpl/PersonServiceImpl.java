package com.example.central_policia.Service.ServiceImpl;

import com.example.central_policia.ExceptionHandler.FindPerson;
import com.example.central_policia.Model.DTOs.PersonDTO;
import com.example.central_policia.Model.Entity.*;
import com.example.central_policia.Repository.iMunicipioRepository;
import com.example.central_policia.Repository.iPersonRepository;
import com.example.central_policia.Service.iPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements iPersonService {
    private final iPersonRepository personRepository;
    private final iMunicipioRepository municipioRepository;

    @Override
    public PersonDTO registerPerson(PersonDTO personDTO) {

        personRepository.findByDui(personDTO.getDui())
                .ifPresent(p -> { throw new FindPerson("Esta persona ya existe!"); });

        Municipio munExist = municipioRepository.findMunById(personDTO.getDireccionDTO().getMunicipioId());

        Direccion nuevaDireccion = Direccion.builder()
                .colonia(personDTO.getDireccionDTO().getColoniaDTO())
                .calle(personDTO.getDireccionDTO().getCalleDTO())
                .municipio(munExist)
                .build();

        Person personToDatabase = Person.builder()
                .name(personDTO.getName())
                .dui(personDTO.getDui())
                .tel(personDTO.getTel())
                .dir(nuevaDireccion)
                .build();

        personRepository.save(personToDatabase);
        return personDTO;
    }
}
