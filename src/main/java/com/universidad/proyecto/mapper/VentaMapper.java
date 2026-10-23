package com.universidad.proyecto.mapper;

import org.springframework.stereotype.Component;
import java.util.List;

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

    public List<VentaDtoS> toVentaDtoSList(List<Venta> ventas) {
        return ventas.stream().map(this::toVentaDtoS).toList();
    }
}
