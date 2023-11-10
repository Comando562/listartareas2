package com.app.api.controller;

import com.app.api.services.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping
    public ResponseEntity<Page<DatosListadoTarea>> listadoTareas(@PageableDefault(size = 2) Pageable paginacion) {
        return ResponseEntity.ok(tareaRepository.findByActivoTrue(paginacion).map(DatosListadoTarea::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTarea> retornaDatosMedico(@PathVariable Long id) {
        Tarea tarea = tareaRepository.getReferenceById(id);
        var datosTarea = new DatosRespuestaTarea(tarea.getId(), tarea.getTitulo(), tarea.getDescripcion(), tarea.getFecha());
        return ResponseEntity.ok(datosTarea);
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaTarea> registrarTarea(@RequestBody @Valid DatosRegistroTarea datosRegistroTarea,
                                                              UriComponentsBuilder uriComponentsBuilder) {
        Tarea tarea = tareaRepository.save(new Tarea(datosRegistroTarea));
        DatosRespuestaTarea datosRespuestaTarea = new DatosRespuestaTarea(tarea.getId(), tarea.getTitulo(), tarea.getDescripcion(), tarea.getFecha());
        URI url = uriComponentsBuilder.path("tareas/{id}").buildAndExpand(tarea.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTarea);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTarea(@RequestBody @Valid DatosActualizarTarea datosActualizarTarea) {
        Tarea tarea = tareaRepository.getReferenceById(datosActualizarTarea.id());
        tarea.actualizarTarea(datosActualizarTarea);
        return ResponseEntity.ok(new DatosRespuestaTarea(tarea.getId(), tarea.getTitulo(), tarea.getDescripcion(),
                tarea.getFecha()));
    }

    @DeleteMapping("/id")
    @Transactional
    public ResponseEntity eliminarTarea(@PathVariable Long id){
        Tarea tarea = tareaRepository.getReferenceById(id);
        tarea.desactivarTarea();
        return ResponseEntity.noContent().build();
    }
}
