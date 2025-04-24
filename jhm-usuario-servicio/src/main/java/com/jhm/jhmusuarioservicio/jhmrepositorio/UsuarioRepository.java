package com.jhm.jhmusuarioservicio.jhmrepositorio;


import com.jhm.jhmusuarioservicio.jhmmodelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCorreo(String correo);
    Optional<Usuario> findByCorreo(String correo);
}