package com.prueba.api_consumer.controller;

import com.prueba.api_consumer.model.User;
import com.prueba.api_consumer.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Controlador de usuarios", description = "Endpoint para exponer los usuarios obtenidos del consumo de una API externa")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @Operation(summary = "Obtiene todos los usuarios",
    description = "Recibe una lista de todos los usuarios devuelvos de una API externa")
    public List<User> getUsers(){

        return userService.getUsers();
    }
}
