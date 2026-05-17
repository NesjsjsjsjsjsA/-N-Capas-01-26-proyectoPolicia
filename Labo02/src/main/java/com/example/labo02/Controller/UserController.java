package com.example.labo02.Controller;

import com.example.labo02.Model.DTOs.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping("/register")
    ResponseEntity<UserDTO> registerUser(@RequestBody @Valid UserDTO userDTO){

    }

}
