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

import com.utp.consultoriomedico.model.Medico;
import com.utp.consultoriomedico.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<List<Medico>> getAllMedicos() {
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.getAllMedicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> findMedicoById(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(medicoService.findMedicoById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Medico> saveMedico(@RequestBody Medico medico) {
        try {
            medicoService.saveMedico(medico);
            return ResponseEntity.status(HttpStatus.CREATED).body(medico);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> updateMedico(@PathVariable int id, @RequestBody Medico medico) {
        try {
            Medico medicoActual = medicoService.findMedicoById(id);
            medicoActual.setNombre(medico.getNombre());
            medicoActual.setApellido(medico.getApellido());
            medicoActual.setTelefono(medico.getTelefono());
            medicoActual.setEmail(medico.getEmail());
            medicoActual.setDireccion(medico.getDireccion());
            medicoActual.setDni(medico.getDni());
            medicoActual.setFechaNacimiento(medico.getFechaNacimiento());
            medicoActual.setSexo(medico.getSexo());
            medicoActual.setEstadoCivil(medico.getEstadoCivil());
            medicoActual.setEspecialidad(medico.getEspecialidad());
            medicoActual.setUsuario(medico.getUsuario());
            medicoActual.setConsultorio(medico.getConsultorio());
            medicoActual.setHorario(medico.getHorario());
            medicoService.saveMedico(medicoActual);
            return ResponseEntity.status(HttpStatus.OK).body(medicoActual);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedico(@PathVariable int id) {
        try {
            medicoService.deleteMedico(id);
            return ResponseEntity.status(HttpStatus.OK).body("Medico eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
}
