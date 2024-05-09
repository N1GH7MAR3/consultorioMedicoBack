package com.utp.consultoriomedico.service;

import java.util.List;

import com.utp.consultoriomedico.model.Medico;

public interface MedicoService {

    List<Medico> getAllMedicos();

    Medico findMedicoById(int id);

    void saveMedico(Medico medico);

    void deleteMedico(int id);
    
}
