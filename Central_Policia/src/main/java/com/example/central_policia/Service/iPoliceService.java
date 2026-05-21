package com.example.central_policia.Service;

import com.example.central_policia.Model.DTOs.PersonDTO;
import com.example.central_policia.Model.DTOs.PoliceDTO;
import com.example.central_policia.Model.Police;

public interface iPoliceService {
    PoliceDTO registerPolice (PersonDTO personDTO, PoliceDTO policeDTO);
}
