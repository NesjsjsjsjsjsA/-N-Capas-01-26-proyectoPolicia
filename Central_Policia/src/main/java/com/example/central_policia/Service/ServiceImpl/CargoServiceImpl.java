package com.example.central_policia.Service.ServiceImpl;

import com.example.central_policia.ExceptionHandler.PoliciaNotFoundException;
import com.example.central_policia.Model.DTOs.AcusadorDTO;
import com.example.central_policia.Model.DTOs.CargoItemDTO;
import com.example.central_policia.Model.DTOs.RegisterCargoRequestDTO;
import com.example.central_policia.Model.Entity.Cargo;
import com.example.central_policia.Model.Entity.Direccion;
import com.example.central_policia.Model.Entity.Municipio;
import com.example.central_policia.Model.Entity.Person;
import com.example.central_policia.Model.Entity.Policia;
import com.example.central_policia.Repository.iCargoRepository;
import com.example.central_policia.Repository.iMunicipioRepository;
import com.example.central_policia.Repository.iPersonRepository;
import com.example.central_policia.Repository.iPoliciaRepository;
import com.example.central_policia.Service.iCargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CargoServiceImpl implements iCargoService {

    private final iCargoRepository cargoRepository;
    private final iPersonRepository personRepository;
    private final iPoliciaRepository policiaRepository;
    private final iMunicipioRepository municipioRepository;

    @Override
    @Transactional
    public String registrarCargos(RegisterCargoRequestDTO request) {

        String duiAcusado = request.getPersona().getDui();
        Person acusado = personRepository.findByDui(duiAcusado)
                .orElseGet(() -> {
                    Municipio municipio = municipioRepository.findMunById(
                            request.getPersona().getDireccionDTO().getMunicipioId());
                    Direccion dir = Direccion.builder()
                            .calle(request.getPersona().getDireccionDTO().getCalleDTO())
                            .colonia(request.getPersona().getDireccionDTO().getColoniaDTO())
                            .municipio(municipio)
                            .build();
                    return personRepository.save(Person.builder()
                            .dui(duiAcusado)
                            .name(request.getPersona().getName())
                            .tel(request.getPersona().getTel())
                            .dir(dir)
                            .build());
                });

        for (CargoItemDTO cargoItem : request.getCargos()) {

            Policia policia = policiaRepository
                    .findCopByCodigo(cargoItem.getCodigoPolicia())
                    .orElseThrow(() -> new PoliciaNotFoundException(cargoItem.getCodigoPolicia()));

            AcusadorDTO acusadorDTO = cargoItem.getAcusador();
            Person acusador = personRepository.findByDui(acusadorDTO.getDui())
                    .orElseGet(() -> personRepository.save(
                            Person.builder()
                                    .dui(acusadorDTO.getDui())
                                    .name(acusadorDTO.getNombre())
                                    .build()
                    ));

            Cargo cargo = Cargo.builder()
                    .fecha(LocalDate.now())
                    .acusado(acusado)
                    .acusador(acusador)
                    .tipo(cargoItem.getTipo())
                    .descripcion(cargoItem.getDescripcion())
                    .policia(policia)
                    .build();

            cargoRepository.save(cargo);
        }

        return "Se registraron " + request.getCargos().size() + " cargo(s) para " + acusado.getName();
    }

    @Override
    public List<Person> obtenerPersonasConCargos() {
        return cargoRepository.findAllPersonsWithCargos();
    }

    @Override
    public List<Person> obtenerTop3MasBuscados() {
        return cargoRepository.findTopMostWanted(PageRequest.of(0, 3));
    }
}
