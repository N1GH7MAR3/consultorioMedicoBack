package com.utp.consultoriomedico.service;

import java.util.List;

import com.utp.consultoriomedico.model.Paciente;

public interface PacienteService {

    List<Paciente> getAllPacientes();

    Paciente findPacienteById(int id);

    void savePaciente(Paciente paciente);

    void deletePaciente(int id);
    
    
}
