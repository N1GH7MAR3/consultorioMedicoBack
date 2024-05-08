package com.utp.consultoriomedico.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.utp.consultoriomedico.model.Horario;
import com.utp.consultoriomedico.repository.HorarioRepository;
import com.utp.consultoriomedico.service.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService {
    private final HorarioRepository horarioRepository;

    public HorarioServiceImpl(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }
    
    public ResponseEntity<List<Horario>> getAllHorarios() {
        return ResponseEntity.status(HttpStatus.OK).body(horarioRepository.findAll());
    }

    public ResponseEntity<Horario> findHorarioById(int id) {
        return ResponseEntity.status(HttpStatus.OK).body(horarioRepository.findById(id).get());
    }

    public ResponseEntity<Horario> saveHorario(Horario horario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioRepository.save(horario));
    }

    public ResponseEntity<Horario> updateHorario(int id, Horario horario) {
        Horario horarioActual = horarioRepository.findById(id).get();
        horarioActual.setHoraInicio(horario.getHoraInicio());
        horarioActual.setHoraFin(horario.getHoraFin());
        return ResponseEntity.status(HttpStatus.OK).body(horarioRepository.save(horarioActual));
    }

    public ResponseEntity<String> deleteHorario(int id) {
        horarioRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Horario eliminado");
    }

}
