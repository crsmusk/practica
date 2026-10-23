package com.universidad.proyecto.servicio.InterfacesImpl;
import java.util.List;

import com.universidad.proyecto.dtos.entrada.ProductoDtoE;
import com.universidad.proyecto.dtos.salida.ProductoDtoS;
import com.universidad.proyecto.entidades.Categoria;
import com.universidad.proyecto.entidades.Producto;
import com.universidad.proyecto.repositorio.CategorioRepo;
import com.universidad.proyecto.repositorio.ProductoRepo;
import com.universidad.proyecto.servicio.interfaces.Iproducto;


public class ProductoServiceImpl implements Iproducto{
    
    private final CategorioRepo categoriaRepo;
    private final ProductoRepo productoRepo;
    public ProductoServiceImpl(ProductoRepo productoRepo, CategorioRepo categoriaRepo) {
        this.productoRepo = productoRepo;
        this.categoriaRepo = categoriaRepo;
    }


    


    @Override
    public void guardar(ProductoDtoE producto) {
       Producto prod = new Producto();
       prod.setCantidad(producto.cantidad());
       prod.setNombreP(producto.nombre());
       prod.setEstado(true);
       prod.setPrecio(producto.precio());
       prod.setCategoria(obtenerCategoria(producto.categoria()));
       this.productoRepo.save(prod);
    }

    @Override
    public void eliminar(String id) {
       if (this.productoRepo.existsById(id)) {
          Producto prod = this.productoRepo.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
          prod.setEstado(false);
          this.productoRepo.save(prod);
       }
    }

    @Override
    public void actualizar(String id, ProductoDtoE producto) {
         Producto prod = this.productoRepo.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
         prod.setCantidad(producto.cantidad());
         prod.setNombreP(producto.nombre());
         prod.setPrecio(producto.precio());
         prod.setCategoria(obtenerCategoria(producto.categoria()));
         this.productoRepo.save(prod);
    }

    @Override
    public List<ProductoDtoS> listar() {
        return this.productoRepo.findByAll();
    }

    @Override
    public List<ProductoDtoS> listarPorCategoria(String categoria) {
       return this.productoRepo.findByCategoria(categoria);
    }

    @Override
    public List<ProductoDtoS> listarPorNombre(String nombre) {
        return this.productoRepo.findByNombre(nombre);
    }

    private Categoria obtenerCategoria(String nombre) {
        return categoriaRepo.findById(nombre).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }


}
