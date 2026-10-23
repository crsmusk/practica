package com.universidad.proyecto.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.universidad.proyecto.dtos.salida.UsuarioDtoS;
import com.universidad.proyecto.entidades.Usuario;


public interface UsuarioRepo extends JpaRepository<Usuario, String> {
   
    @Query("SELECT new com.universidad.proyecto.dtos.salida.UsuarioDtoS(u.userName, u.email) FROM Usuario u ")
    List<UsuarioDtoS> findAllOrderByNombre();

   
    
}
