package com.universidad.proyecto.ProductoServicioImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.universidad.proyecto.repositorio.ProductoRepo;
import com.universidad.proyecto.servicio.InterfacesImpl.ProductoServiceImpl;
import com.universidad.proyecto.dtos.entrada.ProductoDtoE;
import com.universidad.proyecto.entidades.Categoria;
import com.universidad.proyecto.entidades.Producto;
import com.universidad.proyecto.repositorio.CategorioRepo;


@ExtendWith(MockitoExtension.class)
public class productoTest {
    
    @Mock 
    ProductoRepo productoRepo;

    @Mock 
    CategorioRepo categoriaRepo;

    @InjectMocks
    private ProductoServiceImpl productoService;

    @Test 
    public void testProductoGuardar(){
        Categoria categoria = new Categoria();
        categoria.setId("prueba");
        categoria.setNombreCategoria("Categoria Prueba");

        when(categoriaRepo.findById("prueba")).thenReturn(Optional.of(categoria));
        
        ProductoDtoE pruebaDto = new ProductoDtoE("prueba", BigDecimal.ONE, "prueba",55);
        
        productoService.guardar(pruebaDto);
        
        verify(productoRepo).save(
            argThat(producto -> 
                producto.getNombreP().equals("prueba") &&
                producto.getCategoria().getId().equals("prueba") &&
                producto.getPrecio().equals(BigDecimal.ONE) &&
                producto.getCantidad() == 55
            ));
    
    }

    @Test
    public void testEliminarProducto(){
        Producto producto = new Producto();
        producto.setId("prueba");
        producto.setEstado(true);

        when(productoRepo.existsById("prueba")).thenReturn(true);
        when(productoRepo.findById("prueba")).thenReturn(Optional.of(producto));

        productoService.eliminar("prueba");
        
        assertEquals(false, producto.getEstado());

    }
    


}
