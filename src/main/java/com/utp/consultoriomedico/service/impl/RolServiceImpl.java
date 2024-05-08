package com.utp.consultoriomedico.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<List<Rol>> getAllRoles() {
        return ResponseEntity.status(HttpStatus.OK).body(rolRepository.findAll());
    }

    public ResponseEntity<Rol> getRolById(int id) {
        return ResponseEntity.status(HttpStatus.OK).body(rolRepository.findById(id).get());
    }

    public ResponseEntity<Rol> saveRol(Rol rol) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rolRepository.save(rol));
    }
    
    public ResponseEntity<Rol> updateRol(int id, Rol rol) {
        Rol rolActual = rolRepository.findById(id).get();
        rolActual.setTipoRol(rol.getTipoRol());
        return ResponseEntity.status(HttpStatus.OK).body(rolRepository.save(rolActual));
    }

    public ResponseEntity<String> deleteRol(int id) {
        rolRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Rol eliminado");
    }
    

}
