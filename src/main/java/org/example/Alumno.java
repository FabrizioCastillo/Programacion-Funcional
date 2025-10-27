package org.example;

// Archivo: Alumno.java
// Usamos un 'record' para inmutabilidad y concisión.
public record Alumno(String nombre, double nota, String curso) {}