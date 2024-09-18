package com.prueba.api_consumer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo que representa la información de una compañia")
public class Company {

    @Schema(description ="Nombre de la compañia" , example = "Papitas Company")
    private String name;

    @Schema(description ="Frase clave de la compañia" , example = "Las mejores papitas")
    private String catchPhrase;

    @Schema(description ="Slogan de la compañia" , example = "Por unas papas sabrosas")
    private String bs;

}
