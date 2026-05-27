package com.example.central_policia.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "person_data")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String dui;

    private String name;

    private String tel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dir_id", nullable = true, foreignKey = @ForeignKey(name = "fk_person_dir"))
    private Direccion dir;

}
