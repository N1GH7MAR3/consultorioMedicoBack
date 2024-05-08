package com.utp.consultoriomedico.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.utp.consultoriomedico.model.Cita;
import com.utp.consultoriomedico.repository.CitaRepository;
import com.utp.consultoriomedico.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService {
    
    private final CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }
    
    public ResponseEntity<List<Cita>> getAllCitas() {
        return ResponseEntity.status(HttpStatus.OK).body(citaRepository.findAll());
    }

    public ResponseEntity<Cita> findCitaById(int id) {
        return ResponseEntity.status(HttpStatus.OK).body(citaRepository.findById(id).get());
    }

    public ResponseEntity<Cita> saveCita(Cita cita) {
        return ResponseEntity.status(HttpStatus.CREATED).body(citaRepository.save(cita));
    }

    public ResponseEntity<Cita> updateCita(int id, Cita cita) {
        Cita citaActual = citaRepository.findById(id).get();
        citaActual.setFechaCita(cita.getFechaCita());
        citaActual.setHoraCita(cita.getHoraCita());
        citaActual.setEstado(cita.getEstado());
        citaActual.setConsultorio(cita.getConsultorio());
        citaActual.setMedico(cita.getMedico());
        citaActual.setPaciente(cita.getPaciente());
        citaActual.setEspecialidad(cita.getEspecialidad());

        return ResponseEntity.status(HttpStatus.OK).body(citaRepository.save(citaActual));
    }

}
