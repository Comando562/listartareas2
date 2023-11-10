package com.app.api.services;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record DatosRegistroTarea(

        @NotBlank
        String titulo,
        @NotBlank
        String descripcion,
        Date fecha
        ) {

}
