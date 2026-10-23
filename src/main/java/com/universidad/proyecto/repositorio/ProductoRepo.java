package com.universidad.proyecto.repositorio;
import java.util.List;
import com.universidad.proyecto.dtos.salida.ProductoDtoS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.universidad.proyecto.entidades.Producto;
import org.springframework.stereotype.Repository;

public interface ProductoRepo extends JpaRepository<Producto, String>{
    
    @Query("""
        SELECT new com.universidad.proyecto.dtos.salida.ProductoDtoS(p.id, p.nombreP, p.precio, p.cantidad)
        FROM Producto p
        WHERE p.categoria = :categoria
        """
    )
    List<ProductoDtoS> findByCategoria(String categoria);

    @Query("""
        SELECT new com.universidad.proyecto.dtos.salida.ProductoDtoS(p.id, p.nombreP, p.precio, p.cantidad)
        FROM Producto p
        WHERE p.nombreP = :nombre
        """
    )
    List<ProductoDtoS> findByNombre(String nombre);

   @Query("""
        SELECT new com.universidad.proyecto.dtos.salida.ProductoDtoS(p.id, p.nombreP, p.precio, p.cantidad)
        FROM Producto p
        ORDER BY p.nombreP
        """
    )
    List<ProductoDtoS> findByAll();


}
