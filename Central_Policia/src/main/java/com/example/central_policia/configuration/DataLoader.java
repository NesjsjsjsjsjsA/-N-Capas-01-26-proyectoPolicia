package com.example.central_policia.configuration;

import com.example.central_policia.Model.Direcciones.Departamento;
import com.example.central_policia.Repository.iDepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner iniciarDepartamentos(iDepartmentRepository depRepository){
        return args -> {
            if (depRepository.count()==0){

                System.out.println("Cargando datos!!!");

                List<Departamento> departamentos = List.of(
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
                );

                depRepository.saveAll(departamentos);

                System.out.println("Departamentos cargados exitosamente!!!");
            }

            else {
                System.out.println("No se cargaron, ya existen datos!");
            }
        };
    }
}
