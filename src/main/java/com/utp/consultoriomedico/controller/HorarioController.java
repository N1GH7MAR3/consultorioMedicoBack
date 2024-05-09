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

import com.utp.consultoriomedico.model.Horario;
import com.utp.consultoriomedico.service.HorarioService;

@RestController
@RequestMapping("/horario")
public class HorarioController {
    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @GetMapping
    public ResponseEntity<List<Horario>> getAllHorarios() {
        return ResponseEntity.status(HttpStatus.OK).body(horarioService.getAllHorarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> findHorarioById(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(horarioService.findHorarioById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Horario> saveHorario(@RequestBody Horario horario) {
        try {
            horarioService.saveHorario(horario);
            return ResponseEntity.status(HttpStatus.CREATED).body(horario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> updateHorario(@PathVariable int id, @RequestBody Horario horario) {
        try {
            Horario horarioActual = horarioService.findHorarioById(id);
            horarioActual.setHoraInicio(horario.getHoraInicio());
            horarioActual.setHoraFin(horario.getHoraFin());
            horarioService.saveHorario(horarioActual);
            return ResponseEntity.status(HttpStatus.OK).body(horarioActual);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Horario> deleteHorario(@PathVariable int id) {
        try {
            horarioService.deleteHorario(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    
}
