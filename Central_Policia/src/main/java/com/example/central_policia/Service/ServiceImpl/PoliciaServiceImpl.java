package com.example.central_policia.Service.ServiceImpl;

import com.example.central_policia.ExceptionHandler.FindPerson;
import com.example.central_policia.Model.DTOs.PersonDTO;
import com.example.central_policia.Model.DTOs.PoliciaDTO;
import com.example.central_policia.Model.Entity.EstacionPolicial;
import com.example.central_policia.Model.Entity.Person;
import com.example.central_policia.Model.Entity.Policia;
import com.example.central_policia.Repository.*;
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
    public PoliciaDTO registerPolicia(PoliciaDTO policiaDTO, String dui) {

        Policia policeExist = policeRep.findCopByPlaca(policiaDTO.getPlacaOficial());
        if (policeExist != null) throw new FindPerson("Oficial ya registrado!");

        Person personExist = personRep.findPersonByDUI(dui);
        if (personExist == null) {

            throw new RuntimeException("La persona con el DUI " + dui + " no existe. Debe registrarse primero.");
        }

        EstacionPolicial estacionPolicial = estacionRep.findEstId(policiaDTO.getPoliceStationID());
        if (estacionPolicial == null) {
            throw new RuntimeException("La estación policial con ID " + policiaDTO.getPoliceStationID() + " no existe.");
        }

        Policia policeToDatabase = Policia.builder()
                .numeroIdentificacion(policiaDTO.getNumeroIdentificacion())
                .placa(policiaDTO.getPlacaOficial())
                .persona(personExist)
                .estacion(estacionPolicial)
                .build();

        policeRep.save(policeToDatabase);

        return policiaDTO;
    }

}
