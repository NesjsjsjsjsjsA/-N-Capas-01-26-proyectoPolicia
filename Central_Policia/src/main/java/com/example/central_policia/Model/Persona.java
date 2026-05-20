package com.example.central_policia.Model;

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

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;
    private String name;
    private String dir;
    private String tel;
}
