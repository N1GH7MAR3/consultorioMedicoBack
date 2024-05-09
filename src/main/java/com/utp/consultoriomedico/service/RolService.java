package com.utp.consultoriomedico.service;

import java.util.List;

import com.utp.consultoriomedico.model.Rol;

public interface RolService {

    List<Rol> getAllRoles();

    Rol findRolById(int id);

    void saveRol(Rol rol);

    void deleteRol(int id);

}
