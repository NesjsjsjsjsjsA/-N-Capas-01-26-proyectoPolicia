package com.example.central_policia.Service.ServiceImpl;

import com.example.central_policia.ExceptionHandler.FindPerson;
import com.example.central_policia.Model.DTOs.PersonDTO;
import com.example.central_policia.Model.Entity.Calle;
import com.example.central_policia.Model.Entity.Departamento;
import com.example.central_policia.Model.Entity.Municipio;
import com.example.central_policia.Model.Entity.Person;
import com.example.central_policia.Repository.iCalleRepository;
import com.example.central_policia.Repository.iDepartmentRepository;
import com.example.central_policia.Repository.iMunicipioRepository;
import com.example.central_policia.Repository.iPersonRepository;
import com.example.central_policia.Service.iPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements iPersonService {
    private final iPersonRepository personRepository;
    private final iDepartmentRepository departamentoRepository;
    private final iMunicipioRepository municipioRepository;
    private final iCalleRepository calleRepository;

    @Override
    public PersonDTO registerPerson(PersonDTO personDTO) {

        Person personExist = personRepository.findPersonByDUI(personDTO.getDUI(), personDTO.getName());
        if (personExist != null) throw new FindPerson("Esta persona ya existe!");

        Departamento findDepartamento = departamentoRepository.findDPById(personDTO.getDepID());
        Municipio findMun = municipioRepository.findMunById(personDTO.getMunID());
        Calle findCalle = calleRepository.findCalleById(personDTO.getCalleID());


        Person personToDatabase = Person.builder()
                .DUI(personDTO.getDUI())
                .name(personDTO.getName())
                .tel(personDTO.getTel())
                .dep(findDepartamento)
                .mun(findMun)
                .calle(findCalle)
                .build();

        personRepository.save(personToDatabase);
        return personDTO;
    }
}
