package com.universidad.proyecto.dtos.salida;

import java.math.BigDecimal;

public record ProductoDtoS( String id,
    String nombre,
    BigDecimal precio,
    int cantidad) {

}
