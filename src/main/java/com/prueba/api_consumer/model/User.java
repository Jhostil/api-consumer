package com.prueba.api_consumer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa un usuario proveniente de una API externa,
 * que contiene información personal y de contacto, así como datos de dirección y compañía.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo que representa un objeto Usuario de una API externa")
public class User {

    /**
     * Identificador único del usuario.
     */
    @Schema(description ="Identificador único del usuario" , example = "1")
    private int id;

    /**
     * Nombre del usuario.
     */
    @Schema(description ="Nombre del usuario" , example = "Andrés")
    private String name;

    /**
     * Apodo o nombre de usuario.
     */
    @Schema(description ="Apodo del usuario" , example = "Andres0293")
    private String username;

    /**
     * Correo electrónico del usuario.
     */
    @Schema(description ="Correo del usuario" , example = "andres@email.com")
    private String email;

    /**
     * Dirección física del usuario.
     */
    @Schema(description ="Objeto que representa la dirección del usuario")
    private Address address;

    /**
    * Número de teléfono del usuario.
    */
    @Schema(description ="Teléfono del usuario" , example = "1224-54345")
    private String phone;

    /**
     * Sitio web del usuario.
     */
    @Schema(description ="Sitio web del usuario" , example = "miPagina.com")
    private String website;

    /**
     * Compañía en la que trabaja el usuario.
     */
    @Schema(description ="Objeto que representa la compañia del usuario")
    private Company company;


}
