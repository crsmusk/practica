package com.universidad.proyecto.servicio.interfaces;
import com.universidad.proyecto.dtos.entrada.ProductoDtoE;
import java.util.List;

import com.universidad.proyecto.entidades.Producto;

public interface Iproducto {

    public void guardar(ProductoDtoE producto);
    public void eliminar(String id);
    public void actualizar(String id, ProductoDtoE producto);
    public List<Producto> listar();
    public List<Producto> listarPorCategoria(String categoria);
    public List<Producto> listarPorNombre(String nombre);
    
}
