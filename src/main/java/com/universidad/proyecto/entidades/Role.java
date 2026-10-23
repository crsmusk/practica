package com.universidad.proyecto.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor 
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idRol;

    private String nombreRol;


}
