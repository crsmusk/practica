package com.universidad.proyecto.mapper;

import org.springframework.stereotype.Component;

import com.universidad.proyecto.dtos.salida.VentaDtoS;
import com.universidad.proyecto.entidades.Venta;

@Component 
public class VentaMapper {

    public VentaDtoS toVentaDtoS(Venta venta) {
        return VentaDtoS.builder()
                .idVenta(venta.getId())
                .idProductos(venta.getProductos().stream().map(p -> p.getId()).toList())
                .nombreUsuario(venta.getUsuario().getUserName())
                .fecha(venta.getFechaVenta())
                .total(venta.getTotalVenta())
                .build();
    }
}
