package com.universidad.proyecto.CategoriaServiceImplTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.when;
import java.util.Collections;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.argThat;

import org.springframework.boot.test.context.SpringBootTest;

import com.universidad.proyecto.entidades.Categoria;
import com.universidad.proyecto.repositorio.CategorioRepo;
import com.universidad.proyecto.servicio.InterfacesImpl.CategoriaServiceImpl;
import com.universidad.proyecto.servicio.interfaces.Icategoria;


@ExtendWith(MockitoExtension.class)
public class categoriaTest {
    
    
    @Mock
    private CategorioRepo categoriaRepo;

    @InjectMocks
    private CategoriaServiceImpl categoriaService;
     
    @Test 
    public void testGuardaCategoria() {
         categoriaService.guardar("lacteos");

     verify(categoriaRepo).save(
        argThat(categoria ->
            "lacteos".equals(categoria.getNombreCategoria())
        )
       );
        
    }

    @Test 
    public void testListarCategorias(){

        Categoria categoria = new Categoria();
        categoria.setNombreCategoria("lacteos");

        when(categoriaRepo.findAll()).thenReturn(List.of(categoria));

        List<Categoria> categorias = categoriaService.listar();
        assertEquals("lacteos", categorias.get(0).getNombreCategoria());
    }

    @Test 
    public void eliminarCategoria() {
        String id="lacteos";
        
        categoriaService.eliminar(id);

        verify(categoriaRepo).deleteById(id);
    }

    @Test 
    public void actualizarCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNombreCategoria("lacteos");
        categoria.setId("prueba");

        when(categoriaRepo.findById("prueba")).thenReturn(java.util.Optional.of(categoria));

        Categoria categoriaActualizada = categoriaRepo.findById("prueba").orElse(null);

        categoriaService.actualizar("prueba","lacteos");

       
        
        verify(categoriaRepo).save(
            argThat(c -> categoriaActualizada.getNombreCategoria().equals(c.getNombreCategoria()))
        );

    }
    

}
