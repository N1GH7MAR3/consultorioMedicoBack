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

import com.utp.consultoriomedico.model.Paciente;
import com.utp.consultoriomedico.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.getAllPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findPacienteById(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(pacienteService.findPacienteById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Paciente> savePaciente(@RequestBody Paciente paciente) {
        try {
            pacienteService.savePaciente(paciente);
            return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable int id, @RequestBody Paciente paciente) {
        try {
            Paciente pacienteActual = pacienteService.findPacienteById(id);
            pacienteActual.setNombre(paciente.getNombre());
            pacienteActual.setApellido(paciente.getApellido());
            pacienteActual.setTelefono(paciente.getTelefono());
            pacienteActual.setEmail(paciente.getEmail());
            pacienteActual.setDireccion(paciente.getDireccion());
            pacienteActual.setDni(paciente.getDni());
            pacienteActual.setFechaNacimiento(paciente.getFechaNacimiento());
            pacienteActual.setSexo(paciente.getSexo());
            pacienteActual.setEstadoCivil(paciente.getEstadoCivil());
            pacienteActual.setUsuario(paciente.getUsuario());
            pacienteService.savePaciente(pacienteActual);
            return ResponseEntity.status(HttpStatus.OK).body(pacienteActual);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable int id) {
        try {
            pacienteService.deletePaciente(id);
            return ResponseEntity.status(HttpStatus.OK).body("Paciente eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
