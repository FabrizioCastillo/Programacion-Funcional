# Práctica de Programación Funcional en Java

Este proyecto contiene un conjunto de ejercicios prácticos (Casos Prácticos) diseñados para practicar conceptos de programación funcional introducidos en Java 8 y versiones posteriores.

El proyecto utiliza `records` de Java para definir modelos de datos inmutables y aplica diversas operaciones de stream (como `filter`, `map`, `sorted`, `collect`, `groupingBy`, `averagingDouble`, etc.) para procesar colecciones de estos objetos.

## Estructura del Proyecto

El código fuente se encuentra en `src/main/java/org/example/` y define los siguientes modelos de datos (records):

* `Alumno(String nombre, double nota, String curso)`
* `Producto(String nombre, String categoria, double precio, int stock)`
* `Libro(String titulo, String autor, int paginas, double precio)`
* `Empleado(String nombre, String departamento, double salario, int edad)`

La clase `Main.java` contiene el método `main` que ejecuta y muestra los resultados de todos los casos prácticos.

## Casos Prácticos Implementados

La clase `Main` resuelve las siguientes operaciones:

### 1. Caso Práctico: Alumno
* Obtener los nombres de alumnos aprobados (nota >= 7) en mayúsculas y ordenados alfabéticamente.
* Calcular el promedio general de notas de todos los alumnos.
* Agrupar los alumnos por curso.
*  Obtener las 3 notas más altas.

### 2. Caso Práctico: Producto
*  Obtener productos con precio > 100, ordenados por precio de forma descendente.
*  Agrupar productos por categoría y calcular el stock total para cada categoría.
*  Generar un único String con los productos en formato "nombre: precio", separados por "; ".
*  Calcular el precio promedio general y el precio promedio por categoría.

### 3. Caso Práctico: Libro
*  Obtener los títulos de libros con más de 300 páginas, ordenados alfabéticamente.
*  Calcular el promedio de páginas de todos los libros.
*  Agrupar los libros por autor y contar cuántos libros tiene cada uno.
*  Encontrar el libro más caro (usando `max`).

### 4. Caso Práctico: Empleado
*  Obtener los empleados con salario > 2000, ordenados por salario de forma descendente.
*  Calcular el salario promedio general de todos los empleados.
*  Agrupar empleados por departamento y sumar el total de salarios por departamento.
*  Obtener los nombres de los 2 empleados más jóvenes.

## Tecnologías

* **Java (JDK 21):** Utiliza características modernas como Streams, Lambdas, Optionals y Records.
* **Gradle:** Utilizado como el gestor de dependencias y herramienta de construcción del proyecto.

### Requisitos

* JDK 11 o superior.

### Construir el Proyecto

Para compilar el proyecto y descargar las dependencias, ejecuta:

# En Windows
.\gradlew.bat build
