package com.prueba.api_consumer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;

/**
 * Clase que maneja de forma centralizada las excepciones lanzadas por la aplicación.
 * Utiliza la anotación @ControllerAdvice para interceptar y gestionar las excepciones en el controlador.
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * Maneja las excepciones lanzadas por el cliente de tipo RestClientException.
     *
     * @return Un ResponseEntity que contiene en el cuerpo de la respuesta un mensaje de error
     * y el código de estado HTTP 503 (Servicio no disponible).
     */
    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<String> handleRestClientException (){

        return new ResponseEntity<>("Error al obtener los usuarios de la API externa", HttpStatus.SERVICE_UNAVAILABLE);
    }

    /**
     * Maneja las excepciones lanzadas por el cliente de tipo HttpClientErrorException.
     *
     * @param clientError La excepción lanzada por el cliente HTTP.
     * @return Un ResponseEntity que contiene el mensaje de error relacionado con la excepción
     * y el código de estado HTTP asociado.
     */
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> hancleHttpClientErrorException (HttpClientErrorException clientError){
        HttpStatusCode statusCode = clientError.getStatusCode();
        String message = ("Ocurrió un error con el cliente: " + statusCode + " " + clientError.getMessage());

        return new ResponseEntity<>(message, statusCode );
    }

    /**
     * Maneja las excepciones lanzadas por el servidor de tipo HttpServerErrorException.
     *
     * @param serverError La excepción lanzada por el servidor HTTP.
     * @return Un ResponseEntity que contiene el mensaje de error relacionado con la excepción
     * y el código de estado HTTP asociado dentro del rango 500.
     */
    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<String> handleHttpServerErrorException (HttpServerErrorException serverError){
        HttpStatusCode statusCode = serverError.getStatusCode();
        String message = ("Ocurrión un error en el servidor: " + statusCode + " " + serverError.getMessage());

        return new ResponseEntity<>(message, statusCode);
    }

    /**
     * Maneja excepciones genéricas de tipo Exception y RuntimeException.
     *
     * @param exception La excepción genérica lanzada.
     * @return Un ResponseEntity que contiene el mensaje de error relacionado con la excepción
     * y el código de estado HTTP 500 (Error interno del servidor).
     */
    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<String> handleGenericException(Exception exception){

        String message = ("Ocurrión un error: " + exception.getMessage());
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
