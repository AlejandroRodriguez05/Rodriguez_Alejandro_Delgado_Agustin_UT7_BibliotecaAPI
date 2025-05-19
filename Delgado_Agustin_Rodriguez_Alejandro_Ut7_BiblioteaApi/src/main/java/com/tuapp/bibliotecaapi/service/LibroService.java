/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.tuapp.bibliotecaapi.service;

import com.tuapp.bibliotecaapi.model.Libro;
import com.tuapp.bibliotecaapi.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    //listar todos los libros
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }
    
    //obtener libro por id
    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }
    
    //Guardar Libro nuevo
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }
    
    //Eliminar Libro
    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }
    
    //Buscar con filtros y ordenacion
    public List<Libro> buscarLibros(String titulo, Integer anio, String order) {
        return libroRepository.buscarLibros(titulo, anio, order);
    }
}