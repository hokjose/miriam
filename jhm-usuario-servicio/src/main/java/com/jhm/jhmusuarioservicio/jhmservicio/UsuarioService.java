package com.jhm.jhmusuarioservicio.jhmservicio;

import com.jhm.jhmusuarioservicio.jhmmodelo.Usuario;
import com.jhm.jhmusuarioservicio.jhmrepositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Long id, Usuario nuevoUsuario) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        usuario.setNombre(nuevoUsuario.getNombre());
        usuario.setCorreo(nuevoUsuario.getCorreo());
        usuario.setTipo(nuevoUsuario.getTipo());
        usuario.setEstado(nuevoUsuario.getEstado());
        usuario.setCarrera(nuevoUsuario.getCarrera());

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}