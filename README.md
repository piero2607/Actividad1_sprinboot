# API RESTful - Gestión de Excursiones 🏔️

Este proyecto es una API RESTful desarrollada en **Spring Boot** para la gestión administrativa de excursiones. Ha sido creado como parte de la actividad práctica de la asignatura *Desarrollo web en entorno servidor*.

El objetivo principal es poner en práctica la creación de controladores REST, el uso de JavaBeans y la implementación del patrón DAO para el acceso a datos almacenados en memoria (sin usar base de datos).

## 🛠️ Tecnologías utilizadas

*   **Java 17+**
*   **Spring Boot 3+** (Spring Web)
*   **Maven** (Gestión de dependencias)
*   **springdoc-openapi** (Para la documentación e interfaz de Swagger)
*   **Postman** (Para las pruebas de las rutas)

## 🏗️ Arquitectura y Patrones

El proyecto sigue una estructura por capas bien definida:
*   **Model (`model`)**: Contiene la clase `Excursion` con todos sus atributos.
*   **Repository (`repository`)**: Implementa el patrón DAO mediante la interfaz `ExcursionDao` y su implementación `ExcursionImplList`. Los datos se guardan en una lista en memoria (`ArrayList`).
*   **Config (`config`)**: La clase `DataConfig` contiene un `@Bean` que se encarga de precargar 6 excursiones de prueba al arrancar la aplicación para poder probar los diferentes filtros.
*   **Controller (`controller`)**: La clase `ExcursionController` expone todas las rutas de la API.

## 📍 Endpoints disponibles

| Método | Ruta | Descripción |
| :--- | :--- | :--- |
| `GET` | `/` | Lista todas las excursiones con estado "CREADO". |
| `GET` | `/excursion/detalle/{id}` | Muestra el detalle de una excursión por su ID. |
| `GET` | `/excursion/cancelar/{id}` | Cambia el estado de la excursión a "CANCELADO". |
| `GET` / `POST` | `/excursion/modificar/{id}` | GET: Muestra la excursión para editar. POST: Guarda los cambios. |
| `GET` | `/excursion/destacados` | Muestra solo las excursiones destacadas (`destacado = "S"`). |
| `GET` | `/excursion/creados` | Muestra solo las excursiones activas (`estado = "CREADO"`). |
| `GET` | `/excursion/terminados` | Muestra solo las excursiones terminadas (`estado = "TERMINADO"`). |
| `GET` / `POST` | `/excursion/alta` | GET: Devuelve la plantilla vacía. POST: Da de alta una nueva excursión. |

## 🚀 Cómo ejecutar el proyecto

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/TU_USUARIO/TU_REPOSITORIO.git
