package com.example.central_policia.Service;

import com.example.central_policia.Model.DTOs.PoliciaDTO;
import com.example.central_policia.Model.DTOs.RegisterPoliceRequestDTO;

public interface iPoliceService {
    PoliciaDTO registerPolicia(RegisterPoliceRequestDTO request);
}
