package com.jhm.jhmprestamoservicio.jhmservicio;

import lombok.Data;

@Data
public class LibroResponse {
    private Long id;
    private String titulo;
    private int numeroCopias;
}