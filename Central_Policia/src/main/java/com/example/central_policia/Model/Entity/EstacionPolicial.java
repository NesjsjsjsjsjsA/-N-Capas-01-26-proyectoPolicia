package com.example.central_policia.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estacion_policial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstacionPolicial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToOne
    @JoinColumn(name = "direccion_id", nullable = false, foreignKey = @ForeignKey(name = "fk_dir_id"))
    private Direccion direccion;

    @OneToOne
    @JoinColumn(name = "director_id", foreignKey = @ForeignKey(name = "fk_director_id"), nullable = false)
    private Policia director;
}
