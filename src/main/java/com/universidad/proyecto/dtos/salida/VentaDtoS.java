package com.universidad.proyecto.dtos.salida;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate  ;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VentaDtoS {
    private String idVenta;
    private List<String> idProductos;
    private String nombreUsuario;
    private LocalDate fecha;
    private BigDecimal total;

}
