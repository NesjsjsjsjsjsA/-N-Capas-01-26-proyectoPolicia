package com.example.central_policia.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "cargo_data")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "acusado_id", nullable = false, foreignKey = @ForeignKey(name = "fk_acusado_id"))
    private Person acusado;

    @ManyToOne
    @JoinColumn(name = "acusador_id", nullable = false, foreignKey = @ForeignKey(name = "fk_acusador_id"))
    private Person acusador;

    @ManyToOne
    @JoinColumn(name = "policia_id", nullable = false, foreignKey = @ForeignKey(name = "fk_policia_id"))
    private Policia policia;

    @Enumerated(EnumType.STRING)
    private TipoCargo tipo;

    private String descripcion;
}
