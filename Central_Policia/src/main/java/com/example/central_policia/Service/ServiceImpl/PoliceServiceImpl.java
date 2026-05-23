package com.example.central_policia.Service.ServiceImpl;

import com.example.central_policia.ExceptionHandler.FindPerson;
import com.example.central_policia.Model.DTOs.PoliceDTO;
import com.example.central_policia.Model.DTOs.RegisterPoliceRequestDTO;
import com.example.central_policia.Model.Entity.EstacionPolicial;
import com.example.central_policia.Model.Entity.Police;
import com.example.central_policia.Repository.iDepartmentRepository;
import com.example.central_policia.Repository.iEstacionPolicialRepository;
import com.example.central_policia.Repository.iMunicipioRepository;
import com.example.central_policia.Repository.iPoliceRepository;
import com.example.central_policia.Service.iPoliceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PoliceServiceImpl implements iPoliceService {

    private final iPoliceRepository policeRep;
    private final iEstacionPolicialRepository estacionRep;
    private final iDepartmentRepository depRep;
    private final iMunicipioRepository munRep;

    @Override
    public PoliceDTO registerPolice(RegisterPoliceRequestDTO request) {

        PoliceDTO policeDTO = request.getPolicia();

        Police policeExist = policeRep.findPoliceByPlaca(policeDTO.getPlacaOficial());
        if (policeExist != null) throw new FindPerson("Oficial ya registrado!");

        EstacionPolicial estacion = estacionRep.findById(policeDTO.getPoliceStationID()).orElse(null);

        Police policeToDatabase = Police.builder()
                .DUI(request.getPersona().getDUI())
                .name(request.getPersona().getName())
                .tel(request.getPersona().getTel())
                .dep(depRep.findDPById(request.getPersona().getDepID()))
                .mun(munRep.findMunById(request.getPersona().getMunID()))
                .numeroIdentificacion(policeDTO.getNumeroIdentificacion())
                .placaOficial(policeDTO.getPlacaOficial())
                .estacion(estacion)
                .build();

        policeRep.save(policeToDatabase);
        return policeDTO;
    }
}
