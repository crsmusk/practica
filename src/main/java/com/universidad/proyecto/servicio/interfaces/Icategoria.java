package com.universidad.proyecto.servicio.interfaces;

import java.util.List;

import com.universidad.proyecto.entidades.Categoria;

public interface Icategoria {

    public void guardar(String categoria);
    public List<Categoria> listar();
    public void eliminar(String idCategoria);
    public void actualizar(String idCategoria, String nuevoNombre);
}
