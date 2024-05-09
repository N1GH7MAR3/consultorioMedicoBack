package com.utp.consultoriomedico.service;

import java.util.List;

import com.utp.consultoriomedico.model.Usuario;

public interface UsuarioService {
    
    List<Usuario> getAllUsuarios();
 
    Usuario findUsuarioById(int id);

    void saveUsuario(Usuario usuario);

    void deleteUsuario(int id);

}
