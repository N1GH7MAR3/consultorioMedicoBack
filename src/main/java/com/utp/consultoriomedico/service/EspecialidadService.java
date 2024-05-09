package com.utp.consultoriomedico.service;

import java.util.List;

import com.utp.consultoriomedico.model.Especialidad;

public interface EspecialidadService {

    List<Especialidad> getAllEspecialidades();

    Especialidad findEspecialidadById(int id);

    void saveEspecialidad(Especialidad especialidad);

    void deleteEspecialidad(int id);
    
    
}
