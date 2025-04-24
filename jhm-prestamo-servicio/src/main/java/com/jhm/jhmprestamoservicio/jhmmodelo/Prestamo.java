package com.jhm.jhmprestamoservicio.jhmmodelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idLibro;

    private Long idUsuario;

    private LocalDate fechaPrestamo;

    private LocalDate fechaDevolucion;
}