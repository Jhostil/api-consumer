package com.prueba.api_consumer.exeption;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.View;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final View error;

    public GlobalExceptionHandler(View error) {
        this.error = error;
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<String> handleRestClientException (){

        return new ResponseEntity<>("Error al obtener los usuarios de la API externa", HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> hancleHttpClientErrorException (HttpClientErrorException clientError){
        HttpStatusCode statusCode = clientError.getStatusCode();
        String message = ("Ocurrió un error con el cliente: " + statusCode + " " + clientError.getMessage());

        return new ResponseEntity<>(message, statusCode );
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<String> handleHttpServerErrorException (HttpServerErrorException serverError){
        HttpStatusCode statusCode = serverError.getStatusCode();
        String message = ("Ocurrión un error en el servidor: " + statusCode + " " + serverError.getMessage());

        return new ResponseEntity<>(message, statusCode);
    }

    public ResponseEntity<String> handleGenericException(Exception exception){

        String message = ("Ocurrión un error inesperado: " + exception.getMessage());
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
