package com.utp.consultoriomedico.service.impl;

import java.util.List;


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

    @Override
    public List<Horario> getAllHorarios() {
        return horarioRepository.findAll();
    }

    @Override
    public Horario findHorarioById(int id) {
        return horarioRepository.findById(id).get();
    }

    @Override
    public void saveHorario(Horario horario) {
        horarioRepository.save(horario);
    }

    @Override
    public void deleteHorario(int id) {
        horarioRepository.deleteById(id);
    }
    
    
}
