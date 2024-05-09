package com.utp.consultoriomedico.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utp.consultoriomedico.model.Rol;
import com.utp.consultoriomedico.service.RolService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/rol")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<Rol>> getAllRoles() {
        return ResponseEntity.status(HttpStatus.OK).body(rolService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(rolService.findRolById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Rol> saveRol(@RequestBody Rol rol) {
        try {
            rolService.saveRol(rol);
            return ResponseEntity.status(HttpStatus.CREATED).body(rol);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable int id, @RequestBody Rol rol) {
        try {
            Rol rolActual = rolService.findRolById(id);
            rolActual.setTipoRol(rol.getTipoRol());
            rolService.saveRol(rolActual);
            return ResponseEntity.status(HttpStatus.OK).body(rolActual);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRol(@PathVariable int id) {
        try {
            rolService.deleteRol(id);
            return ResponseEntity.status(HttpStatus.OK).body("Rol eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
