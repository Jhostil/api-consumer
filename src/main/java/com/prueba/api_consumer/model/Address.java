package com.prueba.api_consumer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa la información de una dirección.
 * Contiene detalles como calle, número, ciudad, código postal y ubicación geográfica.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo que representa la información de una dirección")
public class Address {

    /**
     * Calle o avenida de la dirección.
     */
    @Schema(description = "Calle/Avenida de la dirección", example = "Carrera 5")
    private String street;

    /**
     * Número de la dirección o unidad dentro de un edificio (suite).
     */
    @Schema(description = "Número de la dirección", example = "Casa 19")
    private String suite;

    /**
     * Ciudad donde se encuentra la dirección.
     */
    @Schema(description = "Ciudad de la dirección", example = "Armenia")
    private String city;

    /**
     * Código postal asociado a la dirección.
     */
    @Schema(description = "Código postal de la dirección ", example = "631001")
    private String zipcode;

    /**
     * Objeto que representa la ubicación geográfica (latitud y longitud) de la dirección.
     */
    @Schema(description = "Objeto que representa la ubicación geográfica de la direccion")
    private Geo geo;

}
