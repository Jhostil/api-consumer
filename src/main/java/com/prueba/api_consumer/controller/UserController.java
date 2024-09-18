package com.prueba.api_consumer.controller;

import com.prueba.api_consumer.model.User;
import com.prueba.api_consumer.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Clase controladora que maneja las peticiones que llegan al endpoint de usuarios
 */
@RestController
@RequestMapping("/api")
@Tag(name = "Controlador de usuarios", description = "Endpoint para exponer los usuarios obtenidos del consumo de una API externa")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Endpoint de tipo GET el cual permite obtener los usuarios obtenidos al consumir una API externa de usuarios
     * @return Retorna un ResponseEntity el cual contiene un JSON con los usuarios obtenidos al consumir la API externa
     */
    @GetMapping("/users")
    @Operation(summary = "Obtiene todos los usuarios",
    description = "Recibe una lista de todos los usuarios devuelvos de una API externa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta, parámetros incorrectos"),
            @ApiResponse(responseCode = "404", description = "El recurso no existe"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor debido a un problema con la API externa")
    })
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
