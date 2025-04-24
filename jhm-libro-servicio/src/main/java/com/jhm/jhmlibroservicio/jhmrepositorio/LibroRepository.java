package com.jhm.jhmlibroservicio.jhmrepositorio;

import com.jhm.jhmlibroservicio.jhmmodelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
}
