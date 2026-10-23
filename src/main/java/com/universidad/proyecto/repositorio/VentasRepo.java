package com.universidad.proyecto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.universidad.proyecto.dtos.entrada.VentaDtoE;
import com.universidad.proyecto.entidades.Venta;

public interface VentasRepo extends JpaRepository<Venta, String> {
   

}
