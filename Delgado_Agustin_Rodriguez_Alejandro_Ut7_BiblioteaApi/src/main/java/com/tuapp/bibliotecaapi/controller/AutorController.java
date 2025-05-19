/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuapp.bibliotecaapi.controller;
import com.tuapp.bibliotecaapi.model.Autor;
import com.tuapp.bibliotecaapi.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author chati
 */
@RestController
@RequestMapping("/api/v1/autores")
public class AutorController {
   private final AutorService autorService;
    
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> getAllAutores() {
        return autorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Autor> getAutorById(@PathVariable Long id) {
        return autorService.findById(id);
    }

    @PostMapping
    public Autor createAutor(@RequestBody Autor autor) {
        return autorService.save(autor);
    }
}
