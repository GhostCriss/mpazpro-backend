# MPAZ PRO — Backend (API REST)

**Microservicio Spring Boot para la gestión y persistencia remota de actividades educativas**

**Desarrollado por:** Josefa Lagos y Cristóbal Ruiz

Proyecto académico de la asignatura **DSY1105 - Desarrollo de Aplicaciones Móviles** (Duoc UC), desarrollado para la **Escuela Escritora Marcela Paz**, San Bernardo.

> **Repositorio de la Aplicación Móvil (Android / Kotlin):** [GhostCriss/Proyecto-MPAZPRO](https://github.com/GhostCriss/Proyecto-MPAZPRO)

---

## 1. Descripción del Proyecto

Este repositorio contiene el microservicio backend de **MPAZ PRO**, desarrollado con **Java y Spring Boot**. Su función es exponer una API REST que permite recibir, almacenar y consultar las actividades y puntajes generados por los estudiantes desde la aplicación móvil Android.

---

## 2. Tecnologías Utilizadas

- **Lenguaje:** Java (JDK 17+).
- **Framework:** Spring Boot (Spring Web / Spring Data JPA).
- **ORM:** Hibernate.
- **Gestor de Dependencias:** Maven (`pom.xml` / Maven Wrapper).
- **IDE:** IntelliJ IDEA.
- **Control de Versiones:** Git y GitHub.

---

## 3. Estructura del Proyecto

```text
mpazpro-backend/
├── src/main/
│   ├── java/cl/duoc/mpazpro_backend/
│   │   ├── controller/
│   │   │   └── ActividadController.java     # Endpoints REST para actividades
│   │   ├── model/
│   │   │   └── Actividad.java               # Entidad JPA (asignatura, puntaje, completada, etc.)
│   │   ├── repository/
│   │   │   └── ActividadRepository.java     # Interfaz JpaRepository para persistencia
│   │   └── MpazproBackendApplication.java   # Clase principal de arranque Spring Boot
│   └── resources/
│       └── application.properties           # Configuración del servidor y base de datos
└── pom.xml                                  # Dependencias Maven
```

---

## 4. Requisitos de Ejecución

- JDK 17 o superior.
- IntelliJ IDEA (o cualquier IDE compatible con Maven y Spring Boot).
- Puerto **`8080`** disponible en el equipo local.

---

## 5. Instalación y Ejecución

1. Clonar el repositorio:
   ```bash
   git clone [https://github.com/GhostCriss/mpazpro-backend.git](https://github.com/GhostCriss/mpazpro-backend.git)
   ```
2. Abrir la carpeta `mpazpro-backend` en **IntelliJ IDEA** y esperar a que Maven descargue las dependencias.
3. Ejecutar la clase principal `MpazproBackendApplication.java` (el servidor quedará escuchando en `http://localhost:8080`).
4. Para conectar el emulador o dispositivo físico de Android con este servidor local, ejecutar en la terminal de Android Studio:
   ```bash
   adb reverse tcp:8080 tcp:8080
   ```

---

## 6. Repositorios y Gestión

- **Frontend Móvil (Android / Jetpack Compose):**
