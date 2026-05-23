package com.example.central_policia.Model.Entity;

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

    @Column(unique = true)
    private String dui;

    private String name;

    private String tel;

    @OneToOne(cascade = CascadeType.ALL) //Guardado automático en la BDD antes de guardarla en la tabla Persona
    @JoinColumn(name = "dir_id", referencedColumnName = "id" ,nullable = false)
    private Direccion dir;

}



/*
Direccion
    Complemento - Cadena
    Municipio
        Nombre municipio - Cadena
        Departamento
            Nombre departamento - Cadena
 */
