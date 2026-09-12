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
│   │   ├── BilbioBarrioApplication.java          # Punto de entrada + bean ModelMapper
│   │   ├── GlobalExceptionHandler.java          # Manejo global de errores (@RestControllerAdvice)
│   │   ├── exceptions/
│   │   │   └── ResourceNotFoundException.java  # Excepción de dominio (404)
│   │   ├── course/
│   │   │   ├── application/
│   │   │   │   └── CourseController.java        # Capa HTTP: endpoints REST
│   │   │   ├── domain/
│   │   │   │   ├── Course.java                  # Entidad JPA
│   │   │   │   └── CourseService.java           # Lógica de negocio
│   │   │   ├── dto/
│   │   │   │   ├── CourseRequestDto.java        # DTO de entrada
│   │   │   │   ├── CourseResponseDto.java       # DTO de salida
│   │   │   │   └── AddStudentToCourseDto.java   # DTO de respuesta para matrícula
│   │   │   └── infrastructure/
│   │   │       └── CourseRepository.java        # Spring Data JPA repository
│   │   ├── student/
│   │   │   ├── application/StudentController.java
│   │   │   ├── domain/
│   │   │   │   ├── Student.java
│   │   │   │   └── StudentService.java
│   │   │   └── infrastructure/StudentRepository.java
│   │   └── teacher/
│   │       ├── application/TeacherController.java
│   │       ├── domain/
│   │       │   ├── Teacher.java
│   │       │   └── TeacherService.java
│   │       └── infrastructure/TeacherRepository.java
│   └── resources/
│       ├── application.properties               # Configuración de la app (PostgreSQL)
│       └── data.sql                             # Datos de ejemplo (se cargan en cada arranque)
└── test/
    └── java/org/bibliobarrio/
        ├── BiblioBarrioApplicationTests.java        # Clase base con el contenedor TestContainers
```