package com.universidad.proyecto.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
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
@Table (name = "usuarios")
public class Usuario {
 @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idUsuario;
    @Column (unique = true, nullable = false,name = "user_name")
    private String userName;
    @Column (nullable = false)
    private String password;
    
    @Column (unique = true, nullable = false)
    private String email;

    private Boolean enabled;
    
    @ManyToMany 
    @JoinTable(
        name = "usuario_roles",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private List<Role> roles = new ArrayList<>();
   
}
