package com.universidad.proyecto.servicio.interfaces;

import com.universidad.proyecto.dtos.entrada.UsuarioDtoE;
import com.universidad.proyecto.dtos.salida.UsuarioDtoS;
import com.universidad.proyecto.entidades.Usuario;

public interface Iusuario {
  
    public void guardar(UsuarioDtoE usuario);
    public void eliminar(String id);
    public void actualizar(String id, UsuarioDtoE usuario);
    public UsuarioDtoS buscarPorId(String id);
    
}
