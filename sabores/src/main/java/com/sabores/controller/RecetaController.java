package com.sabores.controller;

import com.sabores.model.Receta;
import com.sabores.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/recetas")
public class RecetaController {

    @Autowired
    private RecetaRepository recetaRepository;

    //Obtener todas las recetas
    @GetMapping
    public List<Receta> obtenerRecetas(){
        return recetaRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Receta> obtenerRecetaCompleta(@PathVariable Long id) {
        Optional<Receta> receta = recetaRepository.findById(id);
        return receta.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Crear una nueva Receta
    @PostMapping
    public Receta guardarReceta(@RequestBody Receta receta){
        return recetaRepository.save(receta);
    }
    
}
