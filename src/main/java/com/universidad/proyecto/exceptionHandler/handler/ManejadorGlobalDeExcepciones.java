package com.universidad.proyecto.exceptionHandler.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.universidad.proyecto.exceptionHandler.error;
import com.universidad.proyecto.exceptionHandler.exceptions.categoriaNoEncontradaE;

@RestControllerAdvice 
public class ManejadorGlobalDeExcepciones {
 

    @ExceptionHandler(categoriaNoEncontradaE.class)
    public ResponseEntity<error> handleCategoriaNoEncontrada(categoriaNoEncontradaE ex) {
        error err = error.builder()
                .timestamp(LocalDateTime.now())
                .estado(HttpStatus.NOT_FOUND.value())
                .mensaje(ex.getMessage())
                .detalles("Categoría no encontrada en la base de datos")
                .build();
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
