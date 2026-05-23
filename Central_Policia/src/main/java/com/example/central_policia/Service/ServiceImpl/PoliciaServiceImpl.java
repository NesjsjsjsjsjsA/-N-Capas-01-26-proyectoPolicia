package com.example.central_policia.Service.ServiceImpl;

import com.example.central_policia.ExceptionHandler.FindPerson;
import com.example.central_policia.ExceptionHandler.PersonNotFoundException;
import com.example.central_policia.Model.DTOs.PoliciaDTO;
import com.example.central_policia.Model.DTOs.RegisterPoliceRequestDTO;
import com.example.central_policia.Model.Entity.EstacionPolicial;
import com.example.central_policia.Model.Entity.Person;
import com.example.central_policia.Model.Entity.Policia;
import com.example.central_policia.Repository.iEstacionPolicialRepository;
import com.example.central_policia.Repository.iPersonRepository;
import com.example.central_policia.Repository.iPoliciaRepository;
import com.example.central_policia.Service.iPoliceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PoliciaServiceImpl implements iPoliceService {

    private final iPoliciaRepository policeRep;
    private final iEstacionPolicialRepository estacionRep;
    private final iPersonRepository personRep;

    @Override
    public PoliciaDTO registerPolicia(RegisterPoliceRequestDTO request) {

        PoliciaDTO policeDTO = request.getPolicia();

        Policia policeExist = policeRep.findCopByPlaca(policeDTO.getPlacaOficial());
        if (policeExist != null) throw new FindPerson("Oficial ya registrado!");

        Person personExist = personRep.findByDui(request.getPersona().getDui())
                .orElseThrow(() -> new PersonNotFoundException(request.getPersona().getDui()));

        EstacionPolicial estacion = estacionRep.findById(policeDTO.getPoliceStationID())
                .orElseThrow(() -> new RuntimeException(
                        "No se encontró ninguna estación con el ID: " + policeDTO.getPoliceStationID()));

        Policia policeToDatabase = Policia.builder()
                .persona(personExist)
                .numeroIdentificacion(policeDTO.getNumeroIdentificacion())
                .placa(policeDTO.getPlacaOficial())
                .estacion(estacion)
                .build();

        policeRep.save(policeToDatabase);
        return policeDTO;
    }
}
