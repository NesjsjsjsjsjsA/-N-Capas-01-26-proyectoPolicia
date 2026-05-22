package com.example.central_policia.configuration;

import com.example.central_policia.Model.*;
import com.example.central_policia.Model.Direcciones.Departamento;
import com.example.central_policia.Model.Direcciones.Municipio;
import com.example.central_policia.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner iniciarDepartamentos(iDepartmentRepository depRepository) {
        return args -> {
            if (depRepository.count() == 0) {
                System.out.println("Cargando datos!!!");
                depRepository.saveAll(List.of(
                        Departamento.builder().nombre("Ahuachapán").build(),
                        Departamento.builder().nombre("Cabañas").build(),
                        Departamento.builder().nombre("Chalatenango").build(),
                        Departamento.builder().nombre("Cuscatlán").build(),
                        Departamento.builder().nombre("La Libertad").build(),
                        Departamento.builder().nombre("La Paz").build(),
                        Departamento.builder().nombre("La Unión").build(),
                        Departamento.builder().nombre("Morazán").build(),
                        Departamento.builder().nombre("San Miguel").build(),
                        Departamento.builder().nombre("San Salvador").build(),
                        Departamento.builder().nombre("San Vicente").build(),
                        Departamento.builder().nombre("Santa Ana").build(),
                        Departamento.builder().nombre("Sonsonate").build(),
                        Departamento.builder().nombre("Usulután").build()
                ));
                System.out.println("Departamentos cargados exitosamente!!!");
            } else {
                System.out.println("No se cargaron, ya existen datos!");
            }
        };
    }

    @Bean
    CommandLineRunner iniciarMunicipios(iMunicipioRepository munRepository) {
        return args -> {
            if (munRepository.count() == 0) {
                munRepository.saveAll(List.of(
                        Municipio.builder().name("San Salvador").build(),
                        Municipio.builder().name("Soyapango").build(),
                        Municipio.builder().name("Mejicanos").build(),
                        Municipio.builder().name("Santa Ana").build(),
                        Municipio.builder().name("San Miguel").build(),
                        Municipio.builder().name("Santa Tecla").build(),
                        Municipio.builder().name("Apopa").build(),
                        Municipio.builder().name("Ilopango").build(),
                        Municipio.builder().name("Cojutepeque").build(),
                        Municipio.builder().name("Zacatecoluca").build()
                ));
            }
        };
    }

    @Bean
    CommandLineRunner iniciarEstaciones(iEstacionPolicialRepository estacionRepository) {
        return args -> {
            if (estacionRepository.count() == 0) {
                estacionRepository.saveAll(List.of(
                        EstacionPolicial.builder()
                                .nombre("Delegación Central PNC")
                                .direccion("6a Calle Poniente, San Salvador")
                                .build(),
                        EstacionPolicial.builder()
                                .nombre("Subdelegación Santa Ana")
                                .direccion("2a Avenida Sur, Santa Ana")
                                .build(),
                        EstacionPolicial.builder()
                                .nombre("Subdelegación San Miguel")
                                .direccion("Blvd. Tutunichapa, San Miguel")
                                .build()
                ));
            }
        };
    }

    @Bean
    CommandLineRunner iniciarPersonas(
            iPersonRepository personRepository,
            iDepartmentRepository depRepository,
            iMunicipioRepository munRepository) {
        return args -> {
            if (personRepository.count() == 0) {
                Departamento ss = depRepository.findDPById(10L);
                Departamento sa = depRepository.findDPById(12L);
                Municipio munSS = munRepository.findMunById(1L);
                Municipio munSA = munRepository.findMunById(4L);

                personRepository.saveAll(List.of(
                        Person.builder().name("Carlos Martínez").DUI("01234567-8").tel("7111-1001").dep(ss).mun(munSS).build(),
                        Person.builder().name("Ana González").DUI("02345678-9").tel("7111-1002").dep(ss).mun(munSS).build(),
                        Person.builder().name("Luis Hernández").DUI("03456789-0").tel("7111-1003").dep(sa).mun(munSA).build(),
                        Person.builder().name("María López").DUI("04567890-1").tel("7111-1004").dep(sa).mun(munSA).build(),
                        Person.builder().name("Roberto Flores").DUI("05678901-2").tel("7111-1005").dep(ss).mun(munSS).build(),
                        Person.builder().name("Sandra Reyes").DUI("06789012-3").tel("7111-1006").dep(sa).mun(munSA).build()
                ));
            }
        };
    }

    @Bean
    CommandLineRunner iniciarPolicias(
            iPoliceRepository policeRepository,
            iEstacionPolicialRepository estacionRepository) {
        return args -> {
            if (policeRepository.count() == 0) {
                List<EstacionPolicial> estaciones = estacionRepository.findAll();

                if (estaciones.isEmpty()) return;

                policeRepository.saveAll(List.of(
                        Police.builder()
                                .name("Jorge Ramírez").DUI("10000001-0").tel("7200-0001")
                                .numeroIdentificacion("PNC-001").placaOficial("A-1001")
                                .estacion(estaciones.get(0)).build(),
                        Police.builder()
                                .name("Carmen Vásquez").DUI("10000002-0").tel("7200-0002")
                                .numeroIdentificacion("PNC-002").placaOficial("A-1002")
                                .estacion(estaciones.get(0)).build(),
                        Police.builder()
                                .name("Mario Pérez").DUI("10000003-0").tel("7200-0003")
                                .numeroIdentificacion("PNC-003").placaOficial("B-2001")
                                .estacion(estaciones.get(1)).build(),
                        Police.builder()
                                .name("Rosa Mejía").DUI("10000004-0").tel("7200-0004")
                                .numeroIdentificacion("PNC-004").placaOficial("C-3001")
                                .estacion(estaciones.get(2)).build()
                ));
                System.out.println("Policías cargados: PNC-001, PNC-002, PNC-003, PNC-004");
            }
        };
    }
}
