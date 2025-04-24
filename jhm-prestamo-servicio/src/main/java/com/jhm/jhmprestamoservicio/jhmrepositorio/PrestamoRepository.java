package com.jhm.jhmprestamoservicio.jhmrepositorio;

import com.jhm.jhmprestamoservicio.jhmmodelo.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}