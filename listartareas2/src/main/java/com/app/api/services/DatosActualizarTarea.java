package com.app.api.services;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DatosActualizarTarea(@NotNull Long id, String titulo, String descripcion, Date fecha) {
}
