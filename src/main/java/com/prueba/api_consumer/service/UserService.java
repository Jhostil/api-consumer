package com.prueba.api_consumer.service;

import com.prueba.api_consumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    public List<User> getUsers(){

        try {
            ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
            User[] usersArray = responseEntity.getBody();
            return usersArray != null ? Arrays.asList(usersArray) : Collections.emptyList();
        } catch (RestClientException e) {
            // Log the exception or handle it as needed
            return Collections.emptyList(); // Return empty list if there is an exception
        }
    }
}
