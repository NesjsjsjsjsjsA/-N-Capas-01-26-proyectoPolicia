package com.example.central_policia.Model.Direcciones;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dep_data")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long departamento_id;

    private String nombre;
}
