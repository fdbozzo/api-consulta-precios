# Consulta de Precios - OpenAPI 3.0
Microservicio de consulta usando Spring-Boot, Maven y OpenApi 3.0


### Endpoint API REST:
`http://localhost:8080/api/v3/products/price`  

### Software

Las versiones de software utilizadas para desarrollar son las siguientes:  
Maven 3.8.6  
JAVA 11.0.2  
Ubuntu Linux 22.04  
IntelliJ IDEA 2022.2.2 (Community Edition)
SpringBoot con base de datos H2 y datos de ejemplo

## Pasos a Seguir para instalar

A través de una consola o terminal:

1. Descargar el repositorio github

```
git clone https://github.com/fdbozzo/api-consulta-precios.git
cd api-consulta-precios.git
```

2. Ejecutar verificación e instalación de Maven

```
mvn validate
mvn verify
mvn clean install
```

3. Ejecutar el JAR de la carpeta /target


```
java -jar target/swagger-spring-1.0.0.jar
```


## API REST

Con los pasos anteriores debemos tener una API REST escuchando en las siguientes direcciones:

API REST: `http://localhost:8080/api/v3/products/price`  
Documentación OpenApi 3: `http://localhost:8080/swagger-ui/index.html`  
API Docs (JSON): `http://localhost:8080/api_docs`  

Se pueden realizar consultas con los parámetros siguientes:

- `brand_id` Código de marca (ej: `1`)  
- `product_id` Código de producto (ej: `35455`)  
- `qry_date` Fecha/hora del precio a consultar (ej: `2020-10-10T00:00:00Z`)


### Ejemplo de uso:

```
curl -X 'GET' \
  'http://localhost:8080/api/v3/products/price?brand_id=1&product_id=35455&qry_date=2020-10-10T00:00:00Z' \
  -H 'accept: application/json'
```

El resultado será un JSON con el registro del precio encontrado  

### Respuesta de ejemplo:
```
[
  {
    "brand_id": 1,
    "start_date": "2020-06-15T16:00:00Z",
    "end_date": "2020-12-31T23:59:59Z",
    "product_id": 35455,
    "price": 38.95,
    "price_list": 4,
    "priority": 1,
    "curr": "EUR"
  }
]
```


# Parte de esta API ha sido generada con Swagger Generator

Spring Boot Server 


## Overview  
This server was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.  
By using the [OpenAPI-Spec](https://github.com/swagger-api/swagger-core), you can easily generate a server stub.  
This is an example of building a swagger-enabled server in Java using the SpringBoot framework.

The underlying library integrating swagger to SpringBoot is [springdoc-openapi](https://github.com/springdoc/springdoc-openapi)

Start your server as an simple java application  

You can view the api documentation in swagger-ui by pointing to  
http://localhost:8080/  

Change default port value in application.properties
