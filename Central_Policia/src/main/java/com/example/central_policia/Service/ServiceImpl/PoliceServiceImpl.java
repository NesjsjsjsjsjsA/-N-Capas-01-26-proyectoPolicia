package com.example.central_policia.Service.ServiceImpl;

import com.example.central_policia.ExceptionHandler.FindPerson;
import com.example.central_policia.Model.DTOs.PersonDTO;
import com.example.central_policia.Model.DTOs.PoliceDTO;
import com.example.central_policia.Model.Person;
import com.example.central_policia.Model.Police;
import com.example.central_policia.Repository.iPersonRepository;
import com.example.central_policia.Repository.iPoliceRepository;
import com.example.central_policia.Service.iPoliceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PoliceServiceImpl implements iPoliceService {

    private final iPoliceRepository policeRep;
    private final iPersonRepository personRep;

    @Override
    public PoliceDTO registerPolice(PersonDTO personDTO, PoliceDTO policeDTO) {

        Person personExist = personRep.findPersonByDUI(Integer.valueOf(personDTO.getDUI()));

        Police policeExist = policeRep.findPoliceByPlaca(policeDTO.getPlacaOficial());

        if (policeExist != null) throw new FindPerson("Oficial Ya registrado!");

        Police policeToDatabase = Police.builder()
                .placaOficial(policeDTO.getPlacaOficial())
                .person(personExist)
                .build();

        policeRep.save(policeToDatabase);

        return policeDTO;
    }
}
