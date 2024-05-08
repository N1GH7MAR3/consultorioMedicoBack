package com.utp.consultoriomedico.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.utp.consultoriomedico.model.Especialidad;
import com.utp.consultoriomedico.repository.EspecialidadRepository;
import com.utp.consultoriomedico.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {
    private final EspecialidadRepository especialidadRepository;

    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public ResponseEntity<List<Especialidad>> getAllEspecialidades() {
        return ResponseEntity.status(HttpStatus.OK).body(especialidadRepository.findAll());
    }

    public ResponseEntity<Especialidad> findEspecialidadById(int id) {
        return ResponseEntity.status(HttpStatus.OK).body(especialidadRepository.findById(id).get());
    }

    public ResponseEntity<Especialidad> saveEspecialidad(Especialidad especialidad) {
        return ResponseEntity.status(HttpStatus.CREATED).body(especialidadRepository.save(especialidad));
    }

    public ResponseEntity<Especialidad> updateEspecialidad(int id, Especialidad especialidad) {
        Especialidad especialidadActual = especialidadRepository.findById(id).get();
        especialidadActual.setNombre(especialidad.getNombre());
        return ResponseEntity.status(HttpStatus.OK).body(especialidadRepository.save(especialidadActual));
    }

    public ResponseEntity<String> deleteEspecialidad(int id) {
        especialidadRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Especialidad eliminada");
    }

}
