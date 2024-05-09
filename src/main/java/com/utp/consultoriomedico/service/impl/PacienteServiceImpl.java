package com.utp.consultoriomedico.service.impl;


import java.util.List;

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

    @Override
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente findPacienteById(int id) {
        return pacienteRepository.findById(id).get();
    }

    @Override
    public void savePaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    @Override
    public void deletePaciente(int id) {
        pacienteRepository.deleteById(id);
    }

    

}
