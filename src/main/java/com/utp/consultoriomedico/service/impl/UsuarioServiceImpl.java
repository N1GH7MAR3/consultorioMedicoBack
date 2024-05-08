package com.utp.consultoriomedico.service.impl;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.utp.consultoriomedico.model.Usuario;
import com.utp.consultoriomedico.repository.UsuarioRepository;
import com.utp.consultoriomedico.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
    }

    public ResponseEntity<Usuario> saveUsuario(Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    public ResponseEntity<Usuario> updateUsuario(int id, Usuario usuario) {
        Usuario usuarioActual = usuarioRepository.findById(id).get();
        usuarioActual.setUsuario(usuario.getUsuario());
        usuarioActual.setContrasenia(usuario.getContrasenia());
        usuarioActual.setRol(usuario.getRol());
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuarioActual));
    }

    public ResponseEntity<String> deleteUsuario(int id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado");
    }

}
