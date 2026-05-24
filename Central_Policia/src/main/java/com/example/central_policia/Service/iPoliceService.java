package com.example.central_policia.Service;

import com.example.central_policia.Model.DTOs.PersonDTO;
import com.example.central_policia.Model.DTOs.PoliciaDTO;

public interface iPoliceService {
    PoliciaDTO registerPolicia(PoliciaDTO policiaDTO, String dui);
}
