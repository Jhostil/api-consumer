# Microservicio para Consumir API de Usuarios

Este proyecto desarrolla un microservicio que consume una API externa para obtener usuarios y los expone mediante un endpoint. Además, incluye configuración de caché y documentación con Swagger.

## Funcionalidad

El servicio realiza lo siguiente:

1. Consume una API externa para obtener una lista de usuarios.
2. Expone esta lista mediante un endpoint en el microservicio.
3. Usa caché para almacenar los usuarios y evitar llamadas repetidas a la API externa.
4. Maneja las excepciones de forma centralizada.

## Requisitos

- Java Development Kit (JDK) 17+

## Instalación

1. **Clona el repositorio:**

    ```bash
    git clone https://github.com/Jhostil/api-consumer.git
    ```

2. **Navega al directorio del proyecto:**

    ```bash
    cd api-consumer
    ```

3. **Descarga las dependencias:**

    ```bash
    mvn dependency:purge-local-repository
    ```

4. **Compila y ejecuta el proyecto:**

    ```bash
    mvn spring-boot:run
    ```

## Uso

1. Una vez ejecutado el servicio, puedes enviar solicitudes GET a la URL:

    ```
    http://localhost:8080/api/users
    ```

2. **Ejemplo de respuesta esperada:**

    ```json
    [
      {
        "id": 1,
        "name": "Andrés",
        "username": "Andres0293",
        "email": "andres@email.com",
        "address": {
          "street": "Carrera 5",
          "suite": "Casa 19",
          "city": "Armenia",
          "zipcode": "631001",
          "geo": {
            "lat": "-13.242355",
            "lng": "453.23322"
          }
        },
        "phone": "1224-54345",
        "website": "miPagina.com",
        "company": {
          "name": "Papitas Company",
          "catchPhrase": "Las mejores papitas",
          "bs": "Por unas papas sabrosas"
        }
      }
    ]
    ```

## Documentación

Puedes acceder a la documentación de la API en:

http://localhost:8080/swagger-ui.html

## Pruebas Unitarias

El proyecto incluye pruebas unitarias en el archivo `UserTest.java`. Estas pruebas pueden ejecutarse usando JUnit 5.

Para ejecutar las pruebas, usa el siguiente comando:

```bash
mvn test