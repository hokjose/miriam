package com.jhm.jhmprestamoservicio.jhmservicio;

import com.jhm.jhmprestamoservicio.jhmmodelo.Prestamo;
import com.jhm.jhmprestamoservicio.jhmrepositorio.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public Prestamo registrarPrestamo(Long idLibro, Long idUsuario) {

        // 1. Verificar que el usuario esté activo
        String usuarioUrl = "http://localhost:8081/api/usuarios/" + idUsuario; // ajusta puerto
        UsuarioResponse usuario = restTemplate.getForObject(usuarioUrl, UsuarioResponse.class);

        if (usuario == null || !usuario.getEstado().equalsIgnoreCase("ACTIVO")) {
            throw new IllegalStateException("Usuario no activo o no encontrado");
        }

        // 2. Verificar que el libro tenga copias disponibles
        String libroUrl = "http://localhost:8082/api/libros/" + idLibro;
        LibroResponse libro = restTemplate.getForObject(libroUrl, LibroResponse.class);

        if (libro == null || libro.getNumeroCopias() <= 0) {
            throw new IllegalStateException("Libro no disponible");
        }

        // 3. Registrar el préstamo
        Prestamo prestamo = Prestamo.builder()
                .idLibro(idLibro)
                .idUsuario(idUsuario)
                .fechaPrestamo(LocalDate.now())
                .fechaDevolucion(LocalDate.now().plusDays(14)) // 2 semanas
                .build();

        // 4. (Opcional) Actualizar número de copias del libro (no lo hacemos por ahora)

        return prestamoRepository.save(prestamo);
    }

    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }
}