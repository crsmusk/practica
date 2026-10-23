package com.universidad.proyecto.dtos.entrada;
import java.math.BigDecimal;

public record ProductoDtoE(
    String id,
    String nombre,
    BigDecimal precio,
    String categoria,
    int cantidad
) {
}
