package com.example.central_policia.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "police_data")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Police extends Person {

    @Column(unique = true, nullable = false)
    private String numeroIdentificacion;

    @Column(unique = true, nullable = false)
    private String placaOficial;

    @ManyToOne
    @JoinColumn(name = "estacion_id")
    private EstacionPolicial estacion;
}
