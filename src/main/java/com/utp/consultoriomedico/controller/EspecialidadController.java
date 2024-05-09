package com.utp.consultoriomedico.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utp.consultoriomedico.model.Especialidad;
import com.utp.consultoriomedico.service.EspecialidadService;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {
    private final EspecialidadService especialidadService;

    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }
    
    @GetMapping
    public ResponseEntity<List<Especialidad>> getAllEspecialidades() {
        return ResponseEntity.status(HttpStatus.OK).body(especialidadService.getAllEspecialidades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> getEspecialidadById(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(especialidadService.findEspecialidadById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @PostMapping
    public ResponseEntity<Especialidad> saveEspecialidad(@RequestBody Especialidad especialidad) {
        try {
            especialidadService.saveEspecialidad(especialidad);
            return ResponseEntity.status(HttpStatus.CREATED).body(especialidad);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> updateEspecialidad(@PathVariable int id,
            @RequestBody Especialidad especialidad) {
        try {
            Especialidad especialidadActual = especialidadService.findEspecialidadById(id);
            especialidadActual.setNombre(especialidad.getNombre());
            especialidadService.saveEspecialidad(especialidadActual);
            return ResponseEntity.status(HttpStatus.OK).body(especialidadActual);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Especialidad> deleteEspecialidad(@PathVariable int id) {
        try {
            especialidadService.deleteEspecialidad(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
