package com.utp.consultoriomedico.service.impl;

import java.util.List;


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

    @Override
    public List<Especialidad> getAllEspecialidades() {
        return especialidadRepository.findAll();
    }

    @Override
    public Especialidad findEspecialidadById(int id) {
        return especialidadRepository.findById(id).get();
    }

    @Override
    public void saveEspecialidad(Especialidad especialidad) {
        especialidadRepository.save(especialidad);
    }

    @Override
    public void deleteEspecialidad(int id) {
        especialidadRepository.deleteById(id);
    }

    
}
