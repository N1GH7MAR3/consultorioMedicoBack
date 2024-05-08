package com.utp.consultoriomedico.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.utp.consultoriomedico.model.Consultorio;
import com.utp.consultoriomedico.repository.ConsultorioRepository;
import com.utp.consultoriomedico.service.ConsultorioService;

@Service
public class ConsultorioServiceImpl implements ConsultorioService {
    private final ConsultorioRepository consultorioRepository;

    public ConsultorioServiceImpl(ConsultorioRepository consultorioRepository) {
        this.consultorioRepository = consultorioRepository;
    }

    public ResponseEntity<List<Consultorio>> getAllConsultorios() {
        return ResponseEntity.status(HttpStatus.OK).body(consultorioRepository.findAll());
    }

    public ResponseEntity<Consultorio> findConsultorioById(int id) {
        return ResponseEntity.status(HttpStatus.OK).body(consultorioRepository.findById(id).get());
    }

    public ResponseEntity<Consultorio> saveConsultorio(Consultorio consultorio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consultorioRepository.save(consultorio));
    }

    public ResponseEntity<Consultorio> updateConsultorio(int id, Consultorio consultorio) {
        Consultorio consultorioActual = consultorioRepository.findById(id).get();
        consultorioActual.setNumeroConsultorio(consultorio.getNumeroConsultorio());
        consultorioActual.setPiso(consultorio.getPiso());
        consultorioActual.setAla(consultorio.getAla());
        return ResponseEntity.status(HttpStatus.OK).body(consultorioRepository.save(consultorioActual));
    }
    
    public ResponseEntity<String> deleteConsultorio(int id) {
        consultorioRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Consultorio eliminado");
    }
}
