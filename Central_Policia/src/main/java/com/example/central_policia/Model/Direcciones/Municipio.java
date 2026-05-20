package com.example.central_policia.Model.Direcciones;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mun_data")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long municipio_id;

    private String name;


}

