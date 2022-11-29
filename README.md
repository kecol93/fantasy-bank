# FANTASY-BANK

It's FAKE API that's using Spring-Boot(JPA, REST) and external NBP API.

## How to run

Install packages in your local maven repository:
```
mvn clean install
```
Go to app module:
```
cd app/
```
Run the application:
```
mvn spring-boot:run
```

## Usefull links
- Swagger documentation:
  [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- H2 Console: [http://localhost:8080/h2](http://localhost:8080/h2)
```
url: jdbc:h2:mem:fantasydb
username: sa
password: password
```
