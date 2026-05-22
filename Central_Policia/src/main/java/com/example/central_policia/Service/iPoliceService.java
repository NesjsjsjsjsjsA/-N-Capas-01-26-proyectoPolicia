package com.example.central_policia.Service;

import com.example.central_policia.Model.DTOs.PoliceDTO;
import com.example.central_policia.Model.DTOs.RegisterPoliceRequestDTO;

public interface iPoliceService {
    PoliceDTO registerPolice(RegisterPoliceRequestDTO request);
}
