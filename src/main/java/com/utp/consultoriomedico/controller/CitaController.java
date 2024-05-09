package com.utp.consultoriomedico.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utp.consultoriomedico.model.Cita;
import com.utp.consultoriomedico.service.CitaService;

@RestController
@RequestMapping("/cita")
public class CitaController {
    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    ResponseEntity<List<Cita>> getAllCitas() {
        return ResponseEntity.status(HttpStatus.OK).body(citaService.getAllCitas());
    }
    
    @GetMapping("/{id}")
    ResponseEntity<Cita> getCitaById(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(citaService.findCitaById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    ResponseEntity<Cita> saveCita(@RequestBody Cita cita) {
        try {
            citaService.saveCita(cita);
            return ResponseEntity.status(HttpStatus.CREATED).body(cita);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Cita> updateCita(@PathVariable int id, @RequestBody Cita cita) {
        try {
            Cita citaActual = citaService.findCitaById(id);
            citaActual.setFechaCita(cita.getFechaCita());
            citaActual.setHoraCita(cita.getHoraCita());
            citaActual.setEstado(cita.getEstado());
            citaActual.setConsultorio(cita.getConsultorio());
            citaActual.setMedico(cita.getMedico());
            citaActual.setPaciente(cita.getPaciente());
            citaActual.setEspecialidad(cita.getEspecialidad());
            citaService.saveCita(citaActual);
            return ResponseEntity.status(HttpStatus.OK).body(citaActual);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
