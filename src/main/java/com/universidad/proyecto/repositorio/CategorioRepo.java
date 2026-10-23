package com.universidad.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universidad.proyecto.entidades.Categoria;


public interface CategorioRepo extends JpaRepository<Categoria, String> {
   
}
