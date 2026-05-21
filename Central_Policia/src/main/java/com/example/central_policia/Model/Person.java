package com.example.central_policia.Model;

import com.example.central_policia.Model.Direcciones.Departamento;
import com.example.central_policia.Model.Direcciones.Municipio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Table(name = "person_data")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //Datos generales de una persona

    private String DUI;

    private String name;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento dep;

    @ManyToOne
    @JoinColumn(name = "municipio_id")
    private Municipio mun;


    private String tel;

}
