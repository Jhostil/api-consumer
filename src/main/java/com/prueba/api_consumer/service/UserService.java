package com.prueba.api_consumer.service;

import com.prueba.api_consumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Servicio para gestionar la obtención de usuarios desde una API externa.
 * Utiliza RestTemplate para realizar solicitudes HTTP y maneja la caché de resultados.
 */
@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Obtiene una lista de usuarios desde la API externa.
     * La respuesta se almacena en caché para mejorar el rendimiento en solicitudes .
     *
     * @return Lista de usuarios obtenidos de la API externa. Retorna una lista vacía si no hay usuarios.
     * @throws RuntimeException si ocurre un error al consumir la API externa.
     */
    @Cacheable("users")
    public List<User> getUsers(){
        try {
            ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
            User[] usersArray = responseEntity.getBody();
            return usersArray != null ? Arrays.asList(usersArray) : Collections.emptyList();
        } catch (RestClientException e) {
            throw new RuntimeException("Error al consumir la API externa", e);
        }
    }
}
