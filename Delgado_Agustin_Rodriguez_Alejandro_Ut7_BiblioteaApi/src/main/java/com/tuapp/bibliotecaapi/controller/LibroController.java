/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// src/main/java/com/tuapp/bibliotecaapi/controller/LibroController.java
package com.tuapp.bibliotecaapi.controller;

import com.tuapp.bibliotecaapi.model.Libro;
import com.tuapp.bibliotecaapi.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    private final LibroService libroService;

    // Inyección por constructor - Spring lo detecta automáticamente
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Libro> getLibroById(@PathVariable Long id) {
        return libroService.findById(id);
    }

    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.save(libro);
    }

    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
        libro.setId(id);
        return libroService.save(libro);
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id) {
        libroService.deleteById(id);
    }

    @GetMapping("/buscar")
    public List<Libro> buscarLibros(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) Integer anio,
            @RequestParam(required = false, defaultValue = "asc") String order) {

        return libroService.buscarLibros(titulo, anio, order);
    }
}
