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

    // ─────────────────────────────────────────────
    // 1. Departamentos de El Salvador
    // ─────────────────────────────────────────────
    @Bean
    CommandLineRunner iniciarDepartamentos(iDepartmentRepository depRepository) {
        return args -> {
            if (depRepository.count() == 0) {
                System.out.println(">>> Cargando departamentos...");
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
                System.out.println(">>> Departamentos cargados exitosamente.");
            } else {
                System.out.println(">>> Departamentos ya existen, se omite la carga.");
            }
        };
    }

    // ─────────────────────────────────────────────
    // 2. Municipios principales (catálogo)
    // ─────────────────────────────────────────────
    @Bean
    CommandLineRunner iniciarMunicipios(iMunicipioRepository munRepository) {
        return args -> {
            if (munRepository.count() == 0) {
                System.out.println(">>> Cargando municipios...");
                munRepository.saveAll(List.of(
                        Municipio.builder().name("San Salvador").build(),
                        Municipio.builder().name("Soyapango").build(),
                        Municipio.builder().name("Mejicanos").build(),
                        Municipio.builder().name("Santa Ana").build(),
                        Municipio.builder().name("San Miguel").build(),
                        Municipio.builder().name("Santa Tecla").build(),
                        Municipio.builder().name("Apopa").build(),
                        Municipio.builder().name("Ilopango").build(),
                        Municipio.builder().name("Delgado").build(),
                        Municipio.builder().name("Usulután").build(),
                        Municipio.builder().name("Zacatecoluca").build(),
                        Municipio.builder().name("Chalatenango").build(),
                        Municipio.builder().name("Cojutepeque").build(),
                        Municipio.builder().name("San Vicente").build(),
                        Municipio.builder().name("Ahuachapán").build(),
                        Municipio.builder().name("Sonsonate").build(),
                        Municipio.builder().name("La Unión").build(),
                        Municipio.builder().name("San Francisco Gotera").build()
                ));
                System.out.println(">>> Municipios cargados exitosamente.");
            } else {
                System.out.println(">>> Municipios ya existen, se omite la carga.");
            }
        };
    }

    // ─────────────────────────────────────────────
    // 3. Estaciones Policiales (mínimo 2)
    // ─────────────────────────────────────────────
    @Bean
    CommandLineRunner iniciarEstaciones(iEstacionPolicialRepository estacionRepository) {
        return args -> {
            if (estacionRepository.count() == 0) {
                System.out.println(">>> Cargando estaciones policiales...");
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
                System.out.println(">>> Estaciones policiales cargadas exitosamente.");
            } else {
                System.out.println(">>> Estaciones ya existen, se omite la carga.");
            }
        };
    }

    // ─────────────────────────────────────────────
    // 4. Personas del catálogo (mínimo 6)
    // ─────────────────────────────────────────────
    @Bean
    CommandLineRunner iniciarPersonas(
            iPersonRepository personRepository,
            iDepartmentRepository depRepository,
            iMunicipioRepository munRepository) {
        return args -> {
            if (personRepository.count() == 0) {
                System.out.println(">>> Cargando personas de catálogo...");

                // IDs según el orden de inserción de departamentos (IDENTITY)
                Departamento sansalvador = depRepository.findDPById(10L); // San Salvador
                Departamento santaana    = depRepository.findDPById(12L); // Santa Ana
                Municipio munSS          = munRepository.findMunById(1L);  // San Salvador
                Municipio munSA          = munRepository.findMunById(4L);  // Santa Ana

                personRepository.saveAll(List.of(
                        Person.builder().name("Carlos Martínez").DUI("01234567-8").tel("7111-1001").dep(sansalvador).mun(munSS).build(),
                        Person.builder().name("Ana González").DUI("02345678-9").tel("7111-1002").dep(sansalvador).mun(munSS).build(),
                        Person.builder().name("Luis Hernández").DUI("03456789-0").tel("7111-1003").dep(santaana).mun(munSA).build(),
                        Person.builder().name("María López").DUI("04567890-1").tel("7111-1004").dep(santaana).mun(munSA).build(),
                        Person.builder().name("Roberto Flores").DUI("05678901-2").tel("7111-1005").dep(sansalvador).mun(munSS).build(),
                        Person.builder().name("Sandra Reyes").DUI("06789012-3").tel("7111-1006").dep(santaana).mun(munSA).build()
                ));
                System.out.println(">>> Personas cargadas exitosamente.");
            } else {
                System.out.println(">>> Personas ya existen, se omite la carga.");
            }
        };
    }

    // ─────────────────────────────────────────────
    // 5. Policías (mínimo 4)
    //    Depende de personas y estaciones ya creadas
    // ─────────────────────────────────────────────
    @Bean
    CommandLineRunner iniciarPolicias(
            iPoliciaRepository policiaRepository,
            iPersonRepository personRepository,
            iEstacionPolicialRepository estacionRepository) {
        return args -> {
            if (policiaRepository.count() == 0) {
                System.out.println(">>> Cargando policías de catálogo...");

                List<Person> personas         = personRepository.findAll();
                List<EstacionPolicial> estaciones = estacionRepository.findAll();

                if (personas.size() < 4 || estaciones.isEmpty()) {
                    System.out.println(">>> ADVERTENCIA: No hay suficientes personas/estaciones para crear policías.");
                    return;
                }

                policiaRepository.saveAll(List.of(
                        Policia.builder()
                                .numeroIdentificacion("PNC-001")
                                .placa("A-1001")
                                .persona(personas.get(0))
                                .estacion(estaciones.get(0))
                                .build(),
                        Policia.builder()
                                .numeroIdentificacion("PNC-002")
                                .placa("A-1002")
                                .persona(personas.get(1))
                                .estacion(estaciones.get(0))
                                .build(),
                        Policia.builder()
                                .numeroIdentificacion("PNC-003")
                                .placa("B-2001")
                                .persona(personas.get(2))
                                .estacion(estaciones.get(1))
                                .build(),
                        Policia.builder()
                                .numeroIdentificacion("PNC-004")
                                .placa("C-3001")
                                .persona(personas.get(3))
                                .estacion(estaciones.get(2))
                                .build()
                ));
                System.out.println(">>> Policías cargados. Códigos: PNC-001, PNC-002, PNC-003, PNC-004");
            } else {
                System.out.println(">>> Policías ya existen, se omite la carga.");
            }
        };
    }
}
