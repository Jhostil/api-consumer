package com.prueba.api_consumer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo para representar la información de una ubicación")
public class Geo {

    @Schema(description ="Latitud de la ubicación" , example = "-13.242355")
    private String lat;

    @Schema(description ="Longitud de la ubicación" , example = "453.23322")
    private String lng;

}
