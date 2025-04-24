package com.jhm.jhmlibroservicio.jhmmodelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String isbn;

    private String titulo;
    private String autor;
    private String editorial;

    private int numeroCopias;

    private String categoria;
}