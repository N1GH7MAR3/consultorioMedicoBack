package com.utp.consultoriomedico.service;

import java.util.List;

import com.utp.consultoriomedico.model.Consultorio;

public interface ConsultorioService {

    List<Consultorio> getAllConsultorios();

    Consultorio findConsultorioById(int id);

    void saveConsultorio(Consultorio consultorio);

    void deleteConsultorio(int id);
    
    
}
