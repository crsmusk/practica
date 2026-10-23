package com.universidad.proyecto.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor 
@Table (name = "ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDate fechaVenta;
    private BigDecimal totalVenta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    
    @ManyToMany 
    @JoinTable(
        name = "detalle_ventas",
        joinColumns = @JoinColumn(name = "id_venta"),
        inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private List<Producto> productos = new ArrayList<>();
}
