package com.example.central_policia.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "policia_data")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Policia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Código único del oficial — se usa para buscar al policía al registrar un cargo
    @Column(name = "numero_identificacion", unique = true, nullable = false)
    private String numeroIdentificacion;

    @Column(name = "placa", unique = true, nullable = false)
    private String placa;

    // Policia ES una persona
    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Person persona;

    @ManyToOne
    @JoinColumn(name = "estacion_id", nullable = false)
    private EstacionPolicial estacion;
}
