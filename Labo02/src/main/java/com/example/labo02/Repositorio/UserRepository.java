package com.example.labo02.Repositorio;

import com.example.labo02.Model.DTOs.UserDTO;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UserDTO> {
}
