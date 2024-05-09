package com.utp.consultoriomedico.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utp.consultoriomedico.model.Rol;
import com.utp.consultoriomedico.repository.RolRepository;
import com.utp.consultoriomedico.service.RolService;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol findRolById(int id) {
        return rolRepository.findById(id).get();
    }

    @Override
    public void saveRol(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void deleteRol(int id) {
        rolRepository.deleteById(id);
    }

}
