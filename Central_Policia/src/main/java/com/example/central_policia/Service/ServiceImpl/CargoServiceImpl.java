package com.example.central_policia.Service.ServiceImpl;

import com.example.central_policia.ExceptionHandler.PersonNotFoundException;
import com.example.central_policia.ExceptionHandler.PoliciaNotFoundException;
import com.example.central_policia.Model.Cargo;
import com.example.central_policia.Model.DTOs.AcusadorDTO;
import com.example.central_policia.Model.DTOs.CargoItemDTO;
import com.example.central_policia.Model.DTOs.RegisterCargoRequestDTO;
import com.example.central_policia.Model.Person;
import com.example.central_policia.Model.Policia;
import com.example.central_policia.Repository.iCargoRepository;
import com.example.central_policia.Repository.iDepartmentRepository;
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
    private final iDepartmentRepository departamentoRepository;
    private final iMunicipioRepository municipioRepository;

    @Override
    @Transactional
    public String registrarCargos(RegisterCargoRequestDTO request) {

        // 1. Buscar o registrar al acusado por DUI
        String duiAcusado = request.getPersona().getDUI();
        Person acusado = personRepository.findByDUI(duiAcusado)
                .orElseGet(() -> {
                    // Si no existe, lo creamos con los datos del request
                    return personRepository.save(Person.builder()
                            .DUI(duiAcusado)
                            .name(request.getPersona().getName())
                            .tel(request.getPersona().getTel())
                            .dep(departamentoRepository.findDPById(request.getPersona().getDepID()))
                            .mun(municipioRepository.findMunById(request.getPersona().getMunID()))
                            .build());
                });

        // 2. Procesar cada cargo de la lista
        for (CargoItemDTO cargoItem : request.getCargos()) {

            // 2a. Validar que el policía exista — lanza excepción si no se encuentra
            Policia policia = policiaRepository
                    .findByCodigo(cargoItem.getCodigoPolicia())
                    .orElseThrow(() -> new PoliciaNotFoundException(cargoItem.getCodigoPolicia()));

            // 2b. Buscar o registrar al acusador
            AcusadorDTO acusadorDTO = cargoItem.getAcusador();
            Person acusador = personRepository.findByDUI(acusadorDTO.getDui())
                    .orElseGet(() -> personRepository.save(
                            Person.builder()
                                    .DUI(acusadorDTO.getDui())
                                    .name(acusadorDTO.getNombre())
                                    .build()
                    ));

            // 2c. Construir y guardar el cargo
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
        // PageRequest.of(0, 3) limita el resultado a los primeros 3
        return cargoRepository.findTopMostWanted(PageRequest.of(0, 3));
    }
}
