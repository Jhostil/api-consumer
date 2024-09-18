package com.prueba.api_consumer;

import com.prueba.api_consumer.model.Address;
import com.prueba.api_consumer.model.Company;
import com.prueba.api_consumer.model.Geo;
import com.prueba.api_consumer.model.User;
import com.prueba.api_consumer.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUsers(){

        Geo geo = new Geo("-2.34", "2324");
        Address address = new Address("Calle 1", "Casa 10", "Circasia","633001" , geo);
        Company company = new Company("Mi Empresa", "emp", "prueba");
        User user1 = new User(1, "Maria", "mariac23", "maria@email.com", address, "1234", "exaple.com", company);

        Geo geo2 = new Geo("5.234433", "-5.134523");
        Address address2 = new Address("Avenida Bolivar", "Apto 1102", "Bogotá","55523" , geo2);
        Company company2 = new Company("TransNacional de Bebidas", "Multinacional", "Mi market");
        User user2 = new User(2, "Andrés", "andresp02", "andresp@email.com", address2, "2917323", "midominio.com", company2);

        List<User> users = Arrays.asList(user1, user2);

        ResponseEntity<User[]> response = new ResponseEntity<>(users.toArray(new User[0]), HttpStatus.OK);

        Mockito.when(restTemplate.getForEntity(ArgumentMatchers.anyString(), ArgumentMatchers.eq(User[].class)))
                .thenReturn(response);

        List<User> actualUsers = userService.getUsers();

        assertEquals(users.size(), actualUsers.size(), "El número de usuarios debe concidir");
        assertEquals(users.get(0), actualUsers.get(0), "El primer usuario debe coincidir");
        assertEquals(users.get(1), actualUsers.get(1), "El segundo usuario debe coincidir");
    }

}
