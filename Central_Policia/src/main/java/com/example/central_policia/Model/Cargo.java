package com.example.central_policia.Model;

import com.example.central_policia.Model.Enums.TipoCargo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "cargo_data")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "acusador_id", nullable = false)
    private Person acusador;

    @ManyToOne
    @JoinColumn(name = "acusado_id", nullable = false)
    private Person acusado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCargo tipo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "policia_id", nullable = false)
    private Policia policia;
}
