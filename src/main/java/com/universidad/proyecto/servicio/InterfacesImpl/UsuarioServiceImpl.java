package com.universidad.proyecto.servicio.InterfacesImpl;
import com.universidad.proyecto.dtos.entrada.UsuarioDtoE;
import com.universidad.proyecto.dtos.salida.UsuarioDtoS;
import com.universidad.proyecto.entidades.Usuario;
import com.universidad.proyecto.repositorio.UsuarioRepo;
import com.universidad.proyecto.servicio.interfaces.Iusuario;


public class UsuarioServiceImpl implements Iusuario{
    
    private final UsuarioRepo usuarioRepo;

    public UsuarioServiceImpl(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public void guardar(UsuarioDtoE usuario) {
        Usuario usr = new Usuario();
        usr.setUserName(usuario.nombre());
        usr.setEmail(usuario.email());
        usr.setPassword(usuario.password());
        usr.setEnabled(true);
        this.usuarioRepo.save(usr);
    }

    @Override
    public void eliminar(String id) {
       if (this.usuarioRepo.existsById(id)) {
        Usuario usr = this.usuarioRepo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usr.setEnabled(false);
        this.usuarioRepo.save(usr);
       }
    }

    @Override
    public void actualizar(String id, UsuarioDtoE usuario) {
      Usuario usr = this.usuarioRepo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
      usr.setUserName(usuario.nombre());
      usr.setEmail(usuario.email());
      usr.setPassword(usuario.password());
      this.usuarioRepo.save(usr);
    }

    @Override
    public UsuarioDtoS buscarPorId(String id) {
        if(this.usuarioRepo.existsById(id)){
            return this.usuarioRepo.findByiD(id);
        }
        return null;
    }
 

}
