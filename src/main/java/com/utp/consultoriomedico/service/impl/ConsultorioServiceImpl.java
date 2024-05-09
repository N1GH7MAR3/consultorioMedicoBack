package com.utp.consultoriomedico.service.impl;

import java.util.List;


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

    @Override
    public List<Consultorio> getAllConsultorios() {
        return consultorioRepository.findAll();
    }

    @Override
    public Consultorio findConsultorioById(int id) {
        return consultorioRepository.findById(id).get();
    }

    @Override
    public void saveConsultorio(Consultorio consultorio) {
        consultorioRepository.save(consultorio);
    }

    @Override
    public void deleteConsultorio(int id) {
        consultorioRepository.deleteById(id);
    }

    
}
