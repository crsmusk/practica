package com.universidad.proyecto.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.universidad.proyecto.entidades.Categoria;
import com.universidad.proyecto.servicio.interfaces.Icategoria;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    private final Icategoria icategoria;

    public CategoriaController(Icategoria icategoria) {
        this.icategoria = icategoria;
    }

    @PostMapping("/registrar-producto")
    public ResponseEntity<String> postMethodName(@RequestBody String nombreCategoria  ) {
        icategoria.guardar(nombreCategoria);
        
        return ResponseEntity.ok("Categoría registrada correctamente");
    }

    @GetMapping("/mostrar-categorias")
    public ResponseEntity<List<Categoria>> listarCategorias() {
        List<Categoria> categorias = icategoria.listar();
        return ResponseEntity.ok(categorias);
    }

    @DeleteMapping("/eliminar-categoria/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable String id) {
        icategoria.eliminar(id);
        return ResponseEntity.ok("Categoría eliminada correctamente");
    }

    @PutMapping("/actualizar-categoria/{id}")
    public ResponseEntity<String> actualizarCategoria(@PathVariable String id, @RequestBody String entity) {
        icategoria.actualizar(id, entity);
        return ResponseEntity.ok("Categoría actualizada correctamente");
    }
    
    
}
