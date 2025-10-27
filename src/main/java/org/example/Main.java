package org.example;// Archivo: TrabajoPracticoFuncional.java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // --- 1. Caso Práctico: Alumno ---
        System.out.println("--- Caso Practico 1: Alumno ---");
        List<Alumno> alumnos = Arrays.asList(
                new Alumno("Ana", 9.5, "Java"),
                new Alumno("Luis", 6.0, "Web"),
                new Alumno("Pedro", 8.0, "Java"),
                new Alumno("Maria", 5.5, "Python"),
                new Alumno("Juan", 7.5, "Base de Datos"),
                new Alumno("Carla", 10.0, "Java")
        );

        // 1.1: Nombres de alumnos aprobados (nota >= 7) en mayúsculas y ordenados
        List<String> aprobados = alumnos.stream()
                .filter(a -> a.nota() >= 7)
                .map(a -> a.nombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Alumnos aprobados: " + aprobados);

        // 1.2: Promedio general de notas
        double promedioGeneral = alumnos.stream()
                .mapToDouble(Alumno::nota)
                .average()
                .orElse(0.0);
        System.out.println("Promedio general: " + promedioGeneral);

        // 1.3: Agrupar alumnos por curso
        Map<String, List<Alumno>> alumnosPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::curso));
        System.out.println("Alumnos por curso: " + alumnosPorCurso);

        // 1.4: Obtener los 3 mejores promedios (notas)
        List<Double> mejores3Notas = alumnos.stream()
                .map(Alumno::nota)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Las 3 mejores notas: " + mejores3Notas);


        // --- 2. Caso Práctico: Producto ---
        System.out.println("\n--- Caso Practico 2: Producto ---");
        List<Producto> productos = Arrays.asList(
                new Producto("Monitor", "Tecnología", 250.0, 15),
                new Producto("Teclado", "Tecnología", 80.0, 30),
                new Producto("Silla", "Oficina", 150.0, 10),
                new Producto("Mouse", "Tecnología", 40.0, 50),
                new Producto("Mesa", "Oficina", 120.0, 5)
        );

        // 2.1: Productos con precio > 100, ordenados por precio descendente
        List<Producto> productosCaros = productos.stream()
                .filter(p -> p.precio() > 100)
                .sorted(Comparator.comparingDouble(Producto::precio).reversed())
                .collect(Collectors.toList());
        System.out.println("Productos > 100 (desc): " + productosCaros);

        // 2.2: Agrupar por categoría y calcular stock total
        Map<String, Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::categoria,
                        Collectors.summingInt(Producto::stock)
                ));
        System.out.println("Stock por categoria: " + stockPorCategoria);

        // 2.3: String con "nombre: precio" separado por ";"
        String productosString = productos.stream()
                .map(p -> p.nombre() + ": " + p.precio())
                .collect(Collectors.joining("; "));
        System.out.println("String de productos: " + productosString);

        // 2.4: Calcular precio promedio general y por categoría
        double promedioPrecioGeneral = productos.stream()
                .mapToDouble(Producto::precio)
                .average()
                .orElse(0.0);
        System.out.println("Promedio general: " + promedioPrecioGeneral);

        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::categoria,
                        Collectors.averagingDouble(Producto::precio)
                ));
        System.out.println("Promedio por categoria: " + promedioPorCategoria);


        // --- 3. Caso Práctico: Libro ---
        System.out.println("\n--- Caso Práctico 3: Libro ---");
        List<Libro> libros = Arrays.asList(
                new Libro("El Aleph", "Borges", 150, 20.0),
                new Libro("Cien Años de Soledad", "García Márquez", 450, 30.0),
                new Libro("Rayuela", "Cortazar", 500, 35.0),
                new Libro("Ficciones", "Borges", 200, 22.0)
        );

        // 3.1: Títulos de libros con > 300 páginas, ordenados alfabéticamente
        List<String> titulosLargos = libros.stream()
                .filter(l -> l.paginas() > 300)
                .map(Libro::titulo)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Libros > 300 pág: " + titulosLargos);

        // 3.2: Promedio de páginas de todos los libros
        double promedioPaginas = libros.stream()
                .mapToInt(Libro::paginas)
                .average()
                .orElse(0.0);
        System.out.println("Promedio de páginas: " + promedioPaginas);

        // 3.3: Agrupar libros por autor y contar cuántos tiene
        Map<String, Long> librosPorAutor = libros.stream()
                .collect(Collectors.groupingBy(
                        Libro::autor,
                        Collectors.counting()
                ));
        System.out.println("Conteo por autor: " + librosPorAutor);

        // 3.4: Obtener el libro más caro
        Optional<Libro> libroMasCaro = libros.stream()
                .max(Comparator.comparingDouble(Libro::precio));
        System.out.println("Libro mas caro: " + libroMasCaro.orElse(null));


        // --- 4. Caso Práctico: Empleado ---
        System.out.println("\n--- Caso Practico 4: Empleado ---");
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Laura", "Ventas", 2200.0, 28),
                new Empleado("Marcos", "IT", 3000.0, 35),
                new Empleado("Ana", "RRHH", 1900.0, 25),
                new Empleado("David", "Ventas", 2100.0, 23),
                new Empleado("Sofia", "IT", 3100.0, 40)
        );

        // 4.1: Empleados con salario > 2000, ordenados por salario descendente
        List<Empleado> empleadosSalarioAlto = empleados.stream()
                .filter(e -> e.salario() > 2000)
                .sorted(Comparator.comparingDouble(Empleado::salario).reversed())
                .collect(Collectors.toList());
        System.out.println("Empleados > 2000 (desc): " + empleadosSalarioAlto);

        // 4.2: Salario promedio general
        double salarioPromedio = empleados.stream()
                .mapToDouble(Empleado::salario)
                .average()
                .orElse(0.0);
        System.out.println("Salario promedio: " + salarioPromedio);

        // 4.3: Agrupar por departamento y sumar salarios
        Map<String, Double> salariosPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::departamento,
                        Collectors.summingDouble(Empleado::salario)
                ));
        System.out.println("Suma salarios por depto: " + salariosPorDepto);

        // 4.4: Nombres de los 2 empleados más jóvenes
        List<String> empleadosMasJovenes = empleados.stream()
                .sorted(Comparator.comparingInt(Empleado::edad))
                .limit(2)
                .map(Empleado::nombre)
                .collect(Collectors.toList());
        System.out.println("Los 2 más jovenes: " + empleadosMasJovenes);
    }
}