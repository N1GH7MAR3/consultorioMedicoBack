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

import com.utp.consultoriomedico.model.Consultorio;
import com.utp.consultoriomedico.service.ConsultorioService;

@RestController
@RequestMapping("/consultorio")
public class ConsultorioController {
    private final ConsultorioService consultorioService;

    public ConsultorioController(ConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }

    @GetMapping
    public ResponseEntity<List<Consultorio>> getAllConsultorios() {
        return ResponseEntity.status(HttpStatus.OK).body(consultorioService.getAllConsultorios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultorio> getConsultorioById(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(consultorioService.findConsultorioById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Consultorio> saveConsultorio(@RequestBody Consultorio consultorio) {
        try {
            consultorioService.saveConsultorio(consultorio);
            return ResponseEntity.status(HttpStatus.CREATED).body(consultorio);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consultorio> updateConsultorio(@PathVariable int id, @RequestBody Consultorio consultorio) {
        try {
            Consultorio consultorioActual = consultorioService.findConsultorioById(id);
            consultorioActual.setNumeroConsultorio(consultorio.getNumeroConsultorio());
            consultorioActual.setPiso(consultorio.getPiso());
            consultorioActual.setAla(consultorio.getAla());
            consultorioService.saveConsultorio(consultorioActual);
            return ResponseEntity.status(HttpStatus.OK).body(consultorioActual);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Consultorio> deleteConsultorio(@PathVariable int id) {
        try {
            consultorioService.deleteConsultorio(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
