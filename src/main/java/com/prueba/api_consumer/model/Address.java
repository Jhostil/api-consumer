package com.prueba.api_consumer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo que representa la información de una dirección")
public class Address {

    @Schema(description = "Calle/Avenida de la dirección", example = "Carrera 5")
    private String street;

    @Schema(description = "Número de la dirección", example = "Casa 19")
    private String suite;

    @Schema(description = "Ciudad de la dirección", example = "Armenia")
    private String city;

    @Schema(description = "Código postal de la dirección ", example = "631001")
    private String zipcode;

    @Schema(description = "Objeto que representa la ubicación geográfica de la direccion")
    private Geo geo;

}
