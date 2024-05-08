package com.utp.consultoriomedico.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.utp.consultoriomedico.model.Paciente;
import com.utp.consultoriomedico.repository.PacienteRepository;
import com.utp.consultoriomedico.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public ResponseEntity<List<Paciente>> findAllPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pacientes);
    }
    
    public ResponseEntity<Paciente> findPacienteById(int id) {
        Paciente paciente = pacienteRepository.findById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(paciente);
    }

    public ResponseEntity<Paciente> savePaciente(Paciente paciente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteRepository.save(paciente));
    }

    public ResponseEntity<Paciente> updatePaciente(int id, Paciente paciente) {
        Paciente pacienteActual = pacienteRepository.findById(id).get();
        pacienteActual.setNombre(paciente.getNombre());
        pacienteActual.setApellido(paciente.getApellido());
        pacienteActual.setDni(paciente.getDni());
        pacienteActual.setFechaNacimiento(paciente.getFechaNacimiento());
        pacienteActual.setDireccion(paciente.getDireccion());
        pacienteActual.setTelefono(paciente.getTelefono());
        pacienteActual.setEmail(paciente.getEmail());
        pacienteActual.setUsuario(paciente.getUsuario());
        return ResponseEntity.status(HttpStatus.OK).body(pacienteRepository.save(pacienteActual));
    }
    
}
