package com.utp.consultoriomedico.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;

import com.utp.consultoriomedico.model.Medico;
import com.utp.consultoriomedico.repository.MedicoRepository;
import com.utp.consultoriomedico.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico findMedicoById(int id) {
        return medicoRepository.findById(id).get();
    }

    @Override
    public void saveMedico(Medico medico) {
        medicoRepository.save(medico);
    }

    @Override
    public void deleteMedico(int id) {
        medicoRepository.deleteById(id);
    }

}
