package com.example.central_policia.Model.Entity;


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
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "dep_id", nullable = false, foreignKey = @ForeignKey(name = "fk_dep_id"))
    private Departamento dep;


}

