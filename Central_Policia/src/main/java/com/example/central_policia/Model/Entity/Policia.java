package com.example.central_policia.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "policia_data")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Policia{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "numero_identificacion", unique = true, nullable = false)
    private String numeroIdentificacion;

    @Column(name = "placa", unique = true, nullable = false)
    private String placa;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false, foreignKey = @ForeignKey(name = "fk_person_id"))
    private Person persona;

    @ManyToOne
    @JoinColumn(name = "estacion_id", foreignKey = @ForeignKey(name = "fk_estacion_id"))
    private EstacionPolicial estacion;
}
