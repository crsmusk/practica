package com.universidad.proyecto.servicio.interfaces;

import java.util.List;

import com.universidad.proyecto.dtos.entrada.VentaDtoE;
import com.universidad.proyecto.dtos.salida.VentaDtoS;

public interface Iventa {

    public void guardar(VentaDtoE venta);
    public List<VentaDtoS> listar();
    public void eliminar(String idVenta);
}
