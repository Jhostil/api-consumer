package com.prueba.api_consumer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa la información de una compañía, incluyendo
 * su nombre, frase clave y slogan.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo que representa la información de una compañia")
public class Company {

    /**
     * Nombre de la compañía.
     */
    @Schema(description ="Nombre de la compañia" , example = "Papitas Company")
    private String name;

    /**
     * Frase clave o eslogan corto de la compañía.
     */
    @Schema(description ="Frase clave de la compañia" , example = "Las mejores papitas")
    private String catchPhrase;

    /**
     * Slogan o línea de negocio de la compañía.
     */
    @Schema(description ="Slogan de la compañia" , example = "Por unas papas sabrosas")
    private String bs;

}
