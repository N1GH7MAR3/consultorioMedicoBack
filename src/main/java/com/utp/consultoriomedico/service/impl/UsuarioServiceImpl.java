package com.utp.consultoriomedico.service.impl;

import java.util.List;

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

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findUsuarioById(int id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

}
