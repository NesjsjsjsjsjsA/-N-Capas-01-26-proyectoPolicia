package com.example.central_policia.Model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "police_data")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Police extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String placaOficial;

    //Con dudas de esta implementacion
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    //Aun no agregada esta funcion
    //private EstacionPolicial estacionPolicial





}
