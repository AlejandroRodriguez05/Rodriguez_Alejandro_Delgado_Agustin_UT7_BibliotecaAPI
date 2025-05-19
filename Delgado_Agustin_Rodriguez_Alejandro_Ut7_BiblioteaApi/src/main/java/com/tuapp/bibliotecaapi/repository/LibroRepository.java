/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuapp.bibliotecaapi.repository;

import com.tuapp.bibliotecaapi.model.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    public List<Libro> buscarLibros(String titulo, Integer anio, String order);
}