package com.app.api.services;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record DatosTarea(
        @NotBlank
        String titulo,
        @NotBlank
        String descripcion,

        Date fecha,
        @NotBlank
        Boolean completado){
}
