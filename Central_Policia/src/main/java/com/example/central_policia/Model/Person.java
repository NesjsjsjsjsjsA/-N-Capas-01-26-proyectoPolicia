package com.example.central_policia.Model;

import com.example.central_policia.Model.Direcciones.Departamento;
import com.example.central_policia.Model.Direcciones.Municipio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Table(name = "person_data")
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String DUI;

    private String name;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento dep;

    @ManyToOne
    @JoinColumn(name = "municipio_id")
    private Municipio mun;

    private String tel;

    private String calle;

}
