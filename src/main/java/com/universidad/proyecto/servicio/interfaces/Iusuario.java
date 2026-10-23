package com.universidad.proyecto.servicio.interfaces;

import com.universidad.proyecto.entidades.Usuario;

public interface Iusuario {
  
    public void guardar();
    public void eliminar();
    public void actualizar();
    public Usuario buscarPorId(String id);
    
}
