package com.app.api.services;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "tarea")
@Entity(name = "Tarea")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private Date fecha;
    private boolean completado;

    private Boolean activo;

    public Tarea(DatosRegistroTarea datosRegistroTarea){
        this.titulo = datosRegistroTarea.titulo();
        this.descripcion = datosRegistroTarea.descripcion();
        this.fecha = datosRegistroTarea.fecha();
        this.completado = true;
    }

    public void actualizarTarea(DatosActualizarTarea datosActualizarTarea){
        if(datosActualizarTarea.titulo() != null){
            this.titulo = datosActualizarTarea.titulo();
        }
        if(datosActualizarTarea.descripcion() != null){
            this.descripcion = datosActualizarTarea.descripcion();
        }
        if(datosActualizarTarea.fecha() != null){
            this.fecha = datosActualizarTarea.fecha();
        }
    }

    public void desactivarTarea(){
        this.activo = false;
    }
}
