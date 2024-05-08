package com.utp.consultoriomedico.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.utp.consultoriomedico.model.Medico;
import com.utp.consultoriomedico.repository.MedicoRepository;
import com.utp.consultoriomedico.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public ResponseEntity<List<Medico>> getAllMedicos() {
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findAll());
    }

    public ResponseEntity<Medico> findMedicoById(int id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findById(id).get());
    }

    public ResponseEntity<Medico> saveMedico(Medico medico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoRepository.save(medico));
    }

    public ResponseEntity<Medico> updateMedico(int id, Medico medico) {
        Medico medicoActual = medicoRepository.findById(id).get();
        medicoActual.setNombre(medico.getNombre());
        medicoActual.setApellido(medico.getApellido());
        medicoActual.setDni(medico.getDni());
        medicoActual.setFechaNacimiento(medico.getFechaNacimiento());
        medicoActual.setDireccion(medico.getDireccion());
        medicoActual.setTelefono(medico.getTelefono());
        medicoActual.setEmail(medico.getEmail());
        medicoActual.setEspecialidad(medico.getEspecialidad());
        medicoActual.setUsuario(medico.getUsuario());
        medicoActual.setConsultorio(medico.getConsultorio());
        medicoActual.setHorario(medico.getHorario());
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.save(medicoActual));
    }

    public ResponseEntity<String> deleteMedico(int id) {
        medicoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Medico eliminado");
    }

}
