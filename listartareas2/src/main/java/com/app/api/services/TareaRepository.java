package com.app.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository  extends JpaRepository<Tarea, Long> {
    Page<Tarea> findByActivoTrue(Pageable paginacion);
}
