package com.universidad.proyecto.exceptionHandler;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data 
@Builder 
@NoArgsConstructor 
@AllArgsConstructor
public class error {
 private LocalDateTime timestamp;
    private int estado;
    private String mensaje;
    private String detalles;
}
