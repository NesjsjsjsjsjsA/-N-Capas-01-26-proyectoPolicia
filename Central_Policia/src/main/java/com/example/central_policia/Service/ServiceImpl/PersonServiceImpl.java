package com.example.central_policia.Service.ServiceImpl;

import com.example.central_policia.ExceptionHandler.FindPerson;
import com.example.central_policia.Model.DTOs.PersonDTO;
import com.example.central_policia.Model.Direcciones.Departamento;
import com.example.central_policia.Model.Direcciones.Municipio;
import com.example.central_policia.Model.Person;
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

    @Override
    public PersonDTO registerPerson(PersonDTO personDTO) {

        Person personExist = personRepository.findPersonByDUI(personDTO.getDUI());
        if (personExist != null) throw new FindPerson("Esta persona ya existe!");

        Departamento findDepartamento = departamentoRepository.findDPById(personDTO.getDepID());
        Municipio findMun = municipioRepository.findMunById(personDTO.getMunID());

        Person personToDatabase = Person.builder()
                .DUI(personDTO.getDUI())
                .name(personDTO.getName())
                .tel(personDTO.getTel())
                .dep(findDepartamento)
                .mun(findMun)
                .build();

        personRepository.save(personToDatabase);
        return personDTO;
    }
}
