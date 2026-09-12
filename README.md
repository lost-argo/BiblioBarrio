# PC1 - BilbioBarrio

## Para que sirve este Repositorio?

Una municipalidad necesita habilitar una mini-biblioteca digital para un barrio. Se requiere
desarrollar BiblioBarrio, un servicio REST que gestione libros, usuarios y préstamos con
autenticación segura.

## Cómo ejecutar el proyecto

### Prequisitos
- Java 26
- Maven 3.6+
- Docker

### Levantar la Base de Datos

```bash
docker-compose up -d
```

### Arequitectura y estrcutura del Proyecto

El proyecto sigue una **arquitectura en capas** con separación de responsabilidades por paquete, agrupando cada entidad en sus propias subcarpetas `application`, `domain` e `infrastructure`.

```
src/
├── main/
│   ├── java/org/week04lab01/
│   │   ├── BilbioBarrioApplication.java         # Punto de entrada + bean ModelMapper
│   │   ├── GlobalExceptionHandler.java          # Manejo global de errores (@RestControllerAdvice)
│   │   ├── exceptions/
│   │   │   └── BookNotFoundException.java       # Excepción de dominio (404)
│   │   │   └── LoanNotFoundException.java       # Excepción de dominio (404)
│   │   │   └── NoCopiesAvaliableException.java  # Excepción de dominio (409)
│   │   │   └── OverdueLoanException.java        # Excepción de dominio (400)
│   │   │   └── UserAlreadyExistsException.java  # Excepción de dominio (409)
│   │   │   └── UserNotFoundException.java       # Excepción de dominio (404)
│   │   ├── book/
│   │   │   ├── application/
│   │   │   │   └── BookController.java        # Capa HTTP: endpoints REST
│   │   │   ├── domain/
│   │   │   │   ├── Book.java                  # Entidad JPA
│   │   │   │   └── BookService.java           # Lógica de negocio
│   │   │   ├── dto/
│   │   │   │   ├── BookRequestDto.java        # DTO de entrada
│   │   │   │   ├── BookResponseDto.java       # DTO de salida
│   │   │   └── infrastructure/
│   │   │       └── BookRepository.java        # Spring Data JPA repository
│   │   ├── loan/
│   │   │   ├── application/LoanController.java
│   │   │   ├── domain/
│   │   │   │   ├── Loan.java
│   │   │   │   └── LoanService.java
│   │   │   └── infrastructure/LoanRepository.java
│   │   ├── reservation/
│   │   │   ├── application/ReservationController.java
│   │   │   ├── domain/
│   │   │   │   ├── Reservation.java
│   │   │   │   └── ReservationService.java
│   │   │   └── infrastructure/ReservationRepository.java
│   │   ├── user/
│   │   │   ├── application/UserController.java
│   │   │   ├── domain/
│   │   │   │   ├── User.java
│   │   │   │   └── UserService.java
│   │   │   ├── dto/
│   │   │   │   ├── UserRequestDto.java
│   │   │   │   └── UserResponseDto.java
│   │   │   └── infrastructure/UserRepository.java
│   └── resources/
│       ├── application.properties               # Configuración de la app (PostgreSQL)
│       └── data.sql                             # Datos de ejemplo (se cargan en cada arranque)
└── test/
    └── java/org/bibliobarrio/
        ├── BiblioBarrioApplicationTests.java        # Clase base con el contenedor TestContainers
```