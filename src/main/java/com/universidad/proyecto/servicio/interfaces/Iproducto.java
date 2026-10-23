package com.universidad.proyecto.servicio.interfaces;
import com.universidad.proyecto.dtos.entrada.ProductoDtoE;
import com.universidad.proyecto.dtos.salida.ProductoDtoS;

import java.util.List;

import com.universidad.proyecto.entidades.Producto;

public interface Iproducto {

    public void guardar(ProductoDtoE producto);
    public void eliminar(String id);
    public void actualizar(String id, ProductoDtoE producto);
    public List<ProductoDtoS> listar();
    public List<ProductoDtoS> listarPorCategoria(String categoria);
    public List<ProductoDtoS> listarPorNombre(String nombre);
    
}
