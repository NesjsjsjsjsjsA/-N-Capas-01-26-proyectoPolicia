package com.example.central_policia.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "dir_data")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;

    private String colonia;

    @ManyToOne
    @JoinColumn(name = "municipio_id",foreignKey = @ForeignKey(name = "fk_mun_id"))
    private Municipio municipio;

}
