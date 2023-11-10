package com.app.api.services;

import java.util.Date;

public record DatosListadoTarea(Long id, String titulo, String descripcion, Date fecha) {

    public DatosListadoTarea(Tarea tarea){
        this(tarea.getId(), tarea.getTitulo(), tarea.getDescripcion(), tarea.getFecha());
    }
}
