package com.jhm.jhmprestamoservicio.jhmcontrolador;

import com.jhm.jhmprestamoservicio.jhmmodelo.Prestamo;
import com.jhm.jhmprestamoservicio.jhmservicio.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping
    public Prestamo registrarPrestamo(@RequestParam Long idLibro, @RequestParam Long idUsuario) {
        return prestamoService.registrarPrestamo(idLibro, idUsuario);
    }

    @GetMapping
    public List<Prestamo> listarPrestamos() {
        return prestamoService.listarPrestamos();
    }
}
