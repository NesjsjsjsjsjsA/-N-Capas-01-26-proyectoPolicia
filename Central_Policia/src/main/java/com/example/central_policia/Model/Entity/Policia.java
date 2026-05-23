package com.example.central_policia.Model.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "policia_data")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Policia extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(name = "numero_identificacion", unique = true, nullable = false)
    private String numeroIdentificacion;

    @Column(name = "placa", unique = true, nullable = false)
    private String placa;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Person persona;

    @ManyToOne
    @JoinColumn(name = "estacion_id", nullable = false)
    private EstacionPolicial estacion;
}
