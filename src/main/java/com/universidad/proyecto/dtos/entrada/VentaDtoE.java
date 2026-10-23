package com.universidad.proyecto.dtos.entrada;
import java.math.BigDecimal;
import java.util.List;

public record VentaDtoE(
    List<String> idProductos,
    String idUsuario,
    int cantidad,
    BigDecimal total
) {
}