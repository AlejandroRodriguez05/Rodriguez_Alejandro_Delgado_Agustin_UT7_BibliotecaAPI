/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// src/main/java/com/tuapp/bibliotecaapi/repository/LibroRepository.java
package com.tuapp.bibliotecaapi.repository;

import com.tuapp.bibliotecaapi.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTituloContaining(String titulo);
    List<Libro> findByAnioPublicacion(int anio);

    @Query("SELECT l FROM Libro l WHERE (:titulo IS NULL OR l.titulo LIKE %:titulo%) AND " +
           "(:anio IS NULL OR l.anioPublicacion = :anio) ORDER BY " +
           "CASE WHEN :order = 'asc' THEN l.anioPublicacion END ASC, " +
           "CASE WHEN :order = 'desc' THEN l.anioPublicacion END DESC")
    List<Libro> buscarLibros(@Param("titulo") String titulo, 
                           @Param("anio") Integer anio,
                           @Param("order") String order);
}