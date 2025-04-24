package com.jhm.jhmusuarioservicio.jhmmodelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String correo;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo; // ALUMNO o DOCENTE

    @Enumerated(EnumType.STRING)
    private EstadoUsuario estado; // ACTIVO o INACTIVO

    private String carrera;
}