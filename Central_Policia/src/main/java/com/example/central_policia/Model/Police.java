package com.example.central_policia.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "police_data")
@Builder
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
    @JoinColumn(name = "person_id")
    private Person person;

    //Aun no agregada esta funcion
    //private EstacionPolicial estacionPolicial





}
