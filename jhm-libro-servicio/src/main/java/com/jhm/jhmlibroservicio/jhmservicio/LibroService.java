package com.jhm.jhmlibroservicio.jhmservicio;

import com.jhm.jhmlibroservicio.jhmmodelo.Libro;
import com.jhm.jhmlibroservicio.jhmrepositorio.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public Libro registrarLibro(Libro libro) {
        if (libroRepository.existsByIsbn(libro.getIsbn())) {
            throw new IllegalArgumentException("ISBN ya registrado");
        }
        return libroRepository.save(libro);
    }

    public Libro actualizarLibro(Long id, Libro libroActualizado) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado"));

        libro.setTitulo(libroActualizado.getTitulo());
        libro.setAutor(libroActualizado.getAutor());
        libro.setEditorial(libroActualizado.getEditorial());
        libro.setNumeroCopias(libroActualizado.getNumeroCopias());
        libro.setCategoria(libroActualizado.getCategoria());
        return libroRepository.save(libro);
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}