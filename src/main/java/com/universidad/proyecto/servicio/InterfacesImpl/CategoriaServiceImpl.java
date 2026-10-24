package com.universidad.proyecto.servicio.InterfacesImpl;
import org.springframework.stereotype.Service;
import java.util.List;

import com.universidad.proyecto.entidades.Categoria;
import com.universidad.proyecto.exceptionHandler.exceptions.categoriaNoEncontradaE;
import com.universidad.proyecto.repositorio.CategorioRepo;
import com.universidad.proyecto.servicio.interfaces.Icategoria;

@Service
public class CategoriaServiceImpl implements  Icategoria{
    
    private final CategorioRepo categoriaRepo;

    public CategoriaServiceImpl(CategorioRepo categoriaRepo) {
        this.categoriaRepo = categoriaRepo;
    }

    @Override
    public void guardar(String categoria) {
       Categoria cat = new Categoria();
       cat.setNombreCategoria(categoria);
       this.categoriaRepo.save(cat);
    }

    @Override
    public List<Categoria> listar() {
            return this.categoriaRepo.findAll();
    }

    @Override
    public void eliminar(String idCategoria) {
       this.categoriaRepo.deleteById(idCategoria);
    }

    @Override
    public void actualizar(String idCategoria, String nuevoNombre) {
       Categoria cat = this.categoriaRepo.findById(idCategoria).orElseThrow(()->new categoriaNoEncontradaE());
       cat.setNombreCategoria(nuevoNombre);
       this.categoriaRepo.save(cat);
    }

}
