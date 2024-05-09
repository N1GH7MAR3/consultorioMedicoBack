package com.utp.consultoriomedico.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;

import com.utp.consultoriomedico.model.Cita;
import com.utp.consultoriomedico.repository.CitaRepository;
import com.utp.consultoriomedico.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService {
    
    private final CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Cita findCitaById(int id) {
        return citaRepository.findById(id).get();
    }

    @Override
    public void saveCita(Cita cita) {
        citaRepository.save(cita);
    }

    @Override
    public void deleteCita(int id) {
        citaRepository.deleteById(id);
    }
    
   

}
