package com.universidad.proyecto.servicio.InterfacesImpl;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

import com.universidad.proyecto.dtos.entrada.VentaDtoE;
import com.universidad.proyecto.dtos.salida.VentaDtoS;
import com.universidad.proyecto.entidades.Producto;
import com.universidad.proyecto.entidades.Venta;
import com.universidad.proyecto.mapper.VentaMapper;
import com.universidad.proyecto.repositorio.ProductoRepo;
import com.universidad.proyecto.repositorio.UsuarioRepo;
import com.universidad.proyecto.repositorio.VentasRepo;
import com.universidad.proyecto.servicio.interfaces.Iventa;

import jakarta.transaction.Transactional;

@Service
public class VentaServiceImpl implements Iventa{

   
    
    private final VentasRepo ventasRepo;
    private final VentaMapper mapper;
    private final ProductoRepo repoProducto;
    private final UsuarioRepo repoUsuario;

    public VentaServiceImpl(VentasRepo ventasRepo, VentaMapper mapper, ProductoRepo repoProducto, UsuarioRepo repoUsuario) {
        this.ventasRepo = ventasRepo;
        this.mapper = mapper;
        this.repoProducto = repoProducto;
        this.repoUsuario = repoUsuario;
    }

    @Transactional 
    @Override
    public void guardar(VentaDtoE venta) {
        Venta ve=new Venta(); 
        ve.setProductos(this.obtenerProductosPorIds(venta.idProductos()));
        ve.setFechaVenta(LocalDate.now());
        ve.setUsuario(this.repoUsuario.findById(venta.idUsuario()).orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
        ve.setTotalVenta(venta.total());
        this.ventasRepo.save(ve);
    }

    @Override
    public List<VentaDtoS> listar() {
        return mapper.toVentaDtoSList(this.ventasRepo.findAll());
    }

    @Override
    public void eliminar(String idVenta) {
        this.ventasRepo.deleteById(idVenta);
    }
    
    private List<Producto> obtenerProductosPorIds(List<String> ids) {
        return repoProducto.findAllById(ids);
    }

}
