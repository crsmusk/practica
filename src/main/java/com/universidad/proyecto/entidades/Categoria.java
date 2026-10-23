package com.universidad.proyecto.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor 
@Table (name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column (unique = true, nullable = false)
    private String nombreCategoria;

}
