package com.prueba.api_consumer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo que representa un objeto Usuario de una API externa")
public class User {

    @Schema(description ="Identificador único del usuario" , example = "1")
    private int id;

    @Schema(description ="Nombre del usuario" , example = "Andrés")
    private String name;

    @Schema(description ="Apodo del usuario" , example = "Andres0293")
    private String username;

    @Schema(description ="Correo del usuario" , example = "andres@email.com")
    private String email;

    @Schema(description ="Objeto que representa la dirección del usuario")
    private Address address;

    @Schema(description ="Teléfono del usuario" , example = "1224-54345")
    private String phone;

    @Schema(description ="Sitio web del usuario" , example = "miPagina.com")
    private String website;

    @Schema(description ="Objeto que representa la compañia del usuario")
    private Company company;


}
